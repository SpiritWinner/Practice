import java.util.*;
public class UrbanEnterprisesSET { // предприятие городского типа
    private final static String URBAN_ENTERPRISES_TYPE =
            "Название предприятия:%10s, Маршрут городского транспорта: %-5d"; // формат записи для предприятия и маршрута
    private String name; // название предприятия
    private Set<CityTransport> cityTransports; // данные маршрута городского т/с

    public UrbanEnterprisesSET() {
        name = "";
        cityTransports = new TreeSet<CityTransport>();
    }

    public UrbanEnterprisesSET(String name) {
        this.name = name;
        cityTransports = new TreeSet<CityTransport>();
    }

    public UrbanEnterprisesSET(String name, Comparator comp) {
        this.name = name;
        cityTransports = new TreeSet<CityTransport>(comp);
    }

    public UrbanEnterprisesSET(String name, Set set) {
        this.name = name;
        cityTransports = new TreeSet<CityTransport>(set);
    }
    // сеттер
    public void setUrbanName(String name) {
        this.name = name;
    }
    //геттеры
    public String getUrbanName() {
        return name;
    }

    public Set<CityTransport> getCityTransports() {
        return cityTransports;
    }
    // метод toString класса Object возвращаем строку описания объекта
    public String toString() {
        return String.format(URBAN_ENTERPRISES_TYPE, name, getCityNum());
    }
    // добавление маршрута
    public boolean addRoute(CityTransport citTran) {
        return cityTransports.add(citTran);
    }
    // удаление маршрута
    public boolean delRoute(String codeRoute) {
        return cityTransports.remove(new CityTransport(codeRoute, "", "", 0.0, 0));
    }
    // запрос на выборку данных
    public CityTransport getCityTrans(String codeRoute) {
        for (CityTransport cityTransport : cityTransports)
            if (cityTransport.getCodeRoute().equals(codeRoute)) return cityTransport;
        return null;
    }

    public int getCityNum() {
        return cityTransports.size();
    }
    // возвращение средней протяженности маршрута
    public double avgLengthRoute() {
        int num = cityTransports.size();
        if (num == 0) return 0;
        double avg = 0;
        for (CityTransport cityTransport : cityTransports)
            avg += cityTransport.getLengthRoute();
        return avg / num;
    }
    // Маршруты, протяженность которых выше средней
    public UrbanEnterprisesSET aboveAvgLength() {
        double avg = avgLengthRoute();
        UrbanEnterprisesSET enterprises = new UrbanEnterprisesSET(name + 
                " Список маршруотов протяженность которых выше = " + avg);
        for (CityTransport cityTransport : cityTransports)
            if (cityTransport.getLengthRoute() > avg) enterprises.addRoute(cityTransport);
        return enterprises;
    }
    // Маршруты, у которых число остановок в интервале...
    public UrbanEnterprisesSET betweenNumberStops(int d1, int d2) {
        UrbanEnterprisesSET enterprises = new UrbanEnterprisesSET(String.format(
                "%s:Маршруты, у которых число остановок находится в интервале от %2d до %2d", name, d1, d2));
        for (CityTransport cityTransport : cityTransports) {
            if ((cityTransport.getNumberStops() >= d1) && (cityTransport.getNumberStops() <= d2))
                enterprises.addRoute(cityTransport);
        }
        return enterprises;
    }

    public UrbanEnterprisesSET sortLengthAsc() {
        UrbanEnterprisesSET enterprises = new UrbanEnterprisesSET(name +
                "\n (сортировка по возрастанию длинны маршрута)", new CompLengthAsc());
        for (CityTransport cityTransport:cityTransports)enterprises.addRoute(cityTransport);
        return enterprises;
    }

    public UrbanEnterprisesSET sortBallDesc() {
        UrbanEnterprisesSET group = new UrbanEnterprisesSET(name +
                "\n (сортировка по убыванию длинны маршрута)", new CompLengthDesc());
        for (CityTransport citTran:cityTransports) group.addRoute(citTran);
        return group;
    }

    public UrbanEnterprisesSET sortNameAscBallDesc() {
        UrbanEnterprisesSET group = new UrbanEnterprisesSET(name +
                "\n (сортировка по возрастанию номера маршрута и убыванию длинны)", new CompCodeAscLengthDesc());
        for (CityTransport citTran:cityTransports) group.addRoute(citTran);
        return group;
    }

    public void putUrbEnt() {
        System.out.println(name);
        System.out.printf("%s%14s%23s%17s%17s%17s\n",
                "Номер", "Код маршрута", "Название маршрута", "Вид транспорта", "Длина маршрута", "Номер остановки");
        int i = 1;
        for (CityTransport cityTransport : cityTransports) {
            System.out.printf(" %2d %9s %30s %12s %12.2f %14d\n",
                    i, cityTransport.getCodeRoute(), cityTransport.getNameRoute(), cityTransport.getKindTransport(),
                    cityTransport.getLengthRoute(), cityTransport.getNumberStops());
            i++;
        }
    }
}