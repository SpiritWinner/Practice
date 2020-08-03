public class CityTransport implements Comparable <CityTransport>{ // Сущность - Маршрут_Городского_транспорта
   private final static String ROUTE_CITY_TRANSPORT = "Маршрут-%s, %s, %s, %.2f , %d"; //формат записи маршрута
    private String codeRoute; // Код маршрута
    private String nameRoute; // Название маршрута
    private String kindTransport; // Вид транпорта
    private double lengthRoute; // Длина маршрута
    private int numberStops; // Номер остановки
    // конструктор без параметров
    public CityTransport() {
        codeRoute = "";
        nameRoute = "";
        kindTransport = "";
        lengthRoute = 0.0;
        numberStops = 0;
    }
    // конструктор с параметрами
    public CityTransport( String codeRoute, String nameRoute, String kindTransport, double lengthRoute,int numberStops) {
        this.codeRoute = codeRoute;
        this.nameRoute = nameRoute;
        this.kindTransport = kindTransport;
        this.lengthRoute = lengthRoute;
        this.numberStops = numberStops;
    }

    // геттеры
    public int getNumberStops() {
        return numberStops;
    }

    public String getCodeRoute() {
        return codeRoute;
    }

    public String getNameRoute() {
        return nameRoute;
    }

    public String getKindTransport() {
        return kindTransport;
    }

    public double getLengthRoute() {
        return lengthRoute;
    }

    // сеттеры
    public void setNumberStops(int numberStops) {
        this.numberStops = numberStops;
    }

    public void setCodeRoute(String codeRoute) {
        this.codeRoute = codeRoute;
    }

    public void setNameRoute(String nameRoute) {
        this.nameRoute = nameRoute;
    }

    public void setKindTransport(String kindTransport) {
        this.kindTransport = kindTransport;
    }

    public void setLengthRoute(double lengthRoute) {
        this.lengthRoute = lengthRoute;
    }

    // переопределяется метод toString класса Object
    public String toString() {
        return String.format(ROUTE_CITY_TRANSPORT, codeRoute, nameRoute, kindTransport, lengthRoute, numberStops);
    }

    public boolean equals(Object ob) {
        if (ob == this) return true;
        if ((ob == null) || (getClass() != ob.getClass())) return false;
        CityTransport ct = (CityTransport) ob;
        return codeRoute.equals(ct.codeRoute);
    }

    public int hashCode() {
        return 11 * codeRoute.hashCode();
    }

    public int compareTo(CityTransport ciTra) {
        return (this.codeRoute.compareTo(ciTra.codeRoute));
    }
}