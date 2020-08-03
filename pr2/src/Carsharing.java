import java.util.*;
public class Carsharing {
    private final static String CARSHARING_FORMAT_STRING = "Salon: %-s, %-5d cars";
    private String name;
    private Set<Car> cars;

    public Carsharing(){
        name = "";
        cars = new TreeSet<Car>();
    }
    public Carsharing(String name) {
        this.name = name;
        cars = new TreeSet <Car>();
    }

    public Carsharing(String name, Comparator comp) {
        this.name = name;
        cars = new TreeSet <Car>(comp);
    }

    public Carsharing(String name, Set set) {
        this.name = name;
        cars = new TreeSet <Car>(set);
    }

    public void setGroupName(String name) {this.name = name;}

    public String getGroupName() {return name;}

    public Set <Car> getCars() {return cars;}

    public String toString() {
        return String.format(CARSHARING_FORMAT_STRING, name, getCarNum());
    }

    public boolean addCar(Car car) {
        return cars.add(car);
    }

    public boolean delCar(String id) {
        return cars.remove(new Car(id, "", "", 0.0, 0.0, 0));
    }

    public Car getCar (String id) {
        for (Car car:cars)
            if (car.getId().equals(id)) return car;
        return null;
    }

    public int getCarNum() {return cars.size();}

    public double avgCostPerHour() {
        int num = cars.size();
        if (num == 0) return 0;
        double avg = 0;
        for (Car car:cars)
            avg = avg + car.getCostInHour();
        return avg/num;
    }

    public Carsharing aboveAvgCostPerHour() {
        double avg = avgCostPerHour();
        Carsharing group = new Carsharing (name + ": Cars with above than average cost per hour - " + avg);
        for (Car car:cars)
            if (car.getCostInHour() > avg) group.addCar(car);
        return group;
    }

    public Carsharing betweenMileage(double b1, double b2) {
        Carsharing group = new Carsharing (
                String.format ("%s: Cars, with mileage between, from %4.2f before %4.2f", name, b1, b2));
        for (Car car : cars) {
            if ((car.getMileage() >= b1) && (car.getMileage() <= b2)) group.addCar(car);
        }
        return group;
    }

    public Carsharing sortBallAsc() {
        Carsharing group = new Carsharing(name+
                " (сортировка по возрастанию балла)", new CompCostAsc());
        for (Car car:cars) group.addCar(car);
        return group;
    }

    public Carsharing sortBallDesc() {
        Carsharing group = new Carsharing(name +
                " (сортировка по убыванию балла)", new CompCostDesc());
        for (Car car:cars) group.addCar(car);
        return group;
    }

    public Carsharing sortNameAscBallDesc() {
        Carsharing group = new Carsharing(name +
                " (сортировка по возрастанию имени и убыванию балла)", new CompIdAscCostDesc());
        for (Car car:cars) group.addCar(car);
        return group;
    }

    public void printCarsharing() {
        System.out.println(name);
        System.out.printf("%5s%8s%11s%11s%10s%15s%14s\n",
                "Number","id","Mark","Typ Car","Mileage","Cost per Hour","Max time rent");
        int i = 1;
        for (Car car:cars) {
            System.out.printf(" %-7d %-7s %-10s %-12s %-8.2f %-10.2f %-18d\n",
                    i, car.getId(), car.getMark(), car.getTyp(),
                    car.getMileage(), car.getCostInHour(), car.getMaxTime());
            i++;
        }
    }
}
