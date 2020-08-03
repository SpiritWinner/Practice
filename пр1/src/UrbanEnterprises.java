import java.util.*;
public class UrbanEnterprises{ // предприятие городского типа
    private final static String URBAN_ENTERPRISES_TYPE =
            "Название предприятия:%10s, Маршрут городского транспорта: %-5d"; // формат записи для предприятия и маршрута
    private String name; // название предприятия
    private List <CityTransport> cityTransports; // данные маршрута городского т/с

    public UrbanEnterprises() {
        name = "";
        cityTransports = new ArrayList<CityTransport>();
    }

    public UrbanEnterprises(String name){
        this.name = name;
        cityTransports = new ArrayList<CityTransport>();
    }

    public UrbanEnterprises(String name,List list) {
        this.name = name;
        cityTransports = new ArrayList<CityTransport>(list);
    }
    // сеттер
    public void setUrbanName(String name) {
        this.name = name;
    }
    //геттеры
    public String getUrbanName(){
        return name;
    }

    public List <CityTransport> getCityTransports() {
        return cityTransports;
    }
    // метод toString класса Object
    // возвращаем строку описания объекта
    public String toString() {
        return String.format(URBAN_ENTERPRISES_TYPE, name, getCityNum());
    }
    // добавление маршрута
    public boolean addRoute(CityTransport citTran){
        if (getCityTrans(citTran.getCodeRoute()) != null)return false;
        return cityTransports.add(citTran);
    }
    // удаление маршрута
    public boolean delRoute(String codeRoute){
        return cityTransports.remove(new CityTransport(codeRoute, "", "", 0, 0));
    }
    // запрос на выборку данных
    public CityTransport getCityTrans(String codeRoute){
        for(CityTransport cityTransport:cityTransports)
            if(cityTransport.getCodeRoute().equals(codeRoute)) return cityTransport ;
        return null;
    }

    public int getCityNum(){
        return cityTransports.size();
    }
    // возвращение средней протяженности маршрута
    public double avgLengthRoute(){
        int num = cityTransports.size();
        if (num == 0)return 0;
        double avg = 0;
        for (CityTransport cityTransport:cityTransports)
            avg = avg + cityTransport.getLengthRoute();
        return avg/num;
    }
    // Маршруты, протяженность которых выше средней
    public UrbanEnterprises aboveAvgLength(){
        double avg = avgLengthRoute();
        UrbanEnterprises enterprises = new UrbanEnterprises(name+" Список маршруотов протяженность которых выше = "+avg);
        for (CityTransport cityTransport:cityTransports)
            if(cityTransport.getLengthRoute() > avg) enterprises.addRoute(cityTransport);
        return enterprises;
    }
    // Маршруты, у которых число остановок в интервале...
    public UrbanEnterprises betweenLength(int d1, int d2){
        UrbanEnterprises enterprises= new UrbanEnterprises(String.format("%s:Маршруты, у которых число остановок находится в интервале от %2d до %2d",name,d1,d2));
        for (CityTransport cityTransport : cityTransports) {
            if ((cityTransport.getNumberStops() >= d1) && (cityTransport.getNumberStops() <= d2))
                enterprises.addRoute(cityTransport);
        }
        return enterprises;
    }

    public UrbanEnterprises sort() {
        UrbanEnterprises enterprises = new UrbanEnterprises(name, cityTransports);
        Collections.sort(enterprises.cityTransports);
        return enterprises;
    }

    public UrbanEnterprises sort(Comparator comp) {
        UrbanEnterprises enterprises = new UrbanEnterprises(name, cityTransports);
        Collections.sort(enterprises.cityTransports, comp);
        return enterprises;
    }
    public void putUrbEnt(){
        System.out.println(name); // название предприятия
        System.out.printf("%s%14s%23s%17s%17s%17s\n",
                "Номер", "Код маршрута", "Название маршрута", "Вид транспорта", "Длина маршрута", "Номер остановки");
        int i = 1;
        for(CityTransport cityTransport:cityTransports) {
            System.out.printf(" %2d %9s %30s %12s %12.2f %14d\n",
                    i, cityTransport.getCodeRoute(), cityTransport.getNameRoute(),
                    cityTransport.getKindTransport(), cityTransport.getLengthRoute(), cityTransport.getNumberStops());
            i++;
        }
    }
    public void updateId(String codeRouted, String newCodeRouted) {
        if (newCodeRouted.equals(codeRouted)) return;
        if (getCityTrans(newCodeRouted) != null) return;
        getCityTrans(codeRouted).setCodeRoute(newCodeRouted);
    }

    public void delMoreThanAvg() {
        double avg = avgLengthRoute();
        cityTransports.removeIf(cityTransport -> cityTransport.getLengthRoute() < avg);
    }
    /* removeIf() используется для удаления всех элементов ArrayList,
    который удовлетворяет заданному фильтру предикатов,
    который передается в качестве параметра в метод.*/

    public UrbanEnterprises checkFirstLetters(String Letter) {
        UrbanEnterprises newCar = new UrbanEnterprises(
                String.format("Код маршрута начинающего с %s ", Letter));
        Iterator<CityTransport> iter = cityTransports.iterator();
        while (iter.hasNext()) {
            CityTransport citTr = iter.next();
            if (citTr.getCodeRoute().startsWith(Letter)) newCar.addRoute(citTr);
        }
        return newCar;
    }
}