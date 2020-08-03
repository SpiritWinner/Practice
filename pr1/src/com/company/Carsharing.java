package com.company;

import java.util.*;
public class Carsharing {
    private final static String CARSHARING_FORMAT_STRING = "Salon: %-s, %-5d cars";
    private String name;
    private List<Car> cars;

    public Carsharing() {
        name = "";
        cars = new ArrayList<Car>();
    }

    public Carsharing(String name) {
        this.name = name;
        cars = new ArrayList<Car>();
    }

    public Carsharing(String name, List list) {
        this.name = name;
        cars = new ArrayList<Car>(list);
    }

    public void setGroupName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public String toString() {
        return String.format(CARSHARING_FORMAT_STRING, name, getCarNum());
    }

    public boolean addCar(Car car) {
        if (getCar(car.getId()) != null) return false;
        cars.add(car);
        return true;
    }

    public boolean delCar(String id) {
        return cars.remove(new Car(id, "", "", 0.0, 0.0, 0));
    }

    public Car getCar(String id) {
        for (Car car : cars)
            if (car.getId().equals(id)) return car;
        return null;
    }

    public int getCarNum() {
        return cars.size();
    }

    public double avgCostPerHour() {
        double num = cars.size();
        if (num == 0) return 0;
        double avg = 0.0;
        for (Car car : cars)
            avg = avg + car.getCostInHour();
        return avg / num;
    }

    public Carsharing aboveAvgCostPerHour() {
        double avg = avgCostPerHour();
        Carsharing group = new Carsharing(name + ": Cars with above than average cost per hour - " + avg);
        for (Car car : cars)
            if (car.getCostInHour() > avg) group.addCar(car);
        return group;
    }

    public Carsharing betweenMileage(double b1, double b2) {
        Carsharing group = new Carsharing(
                String.format("%s: Cars, with mileage between, from %4.2f before %4.2f", name, b1, b2));
        for (Car car : cars) {
            if ((car.getMileage() >= b1) && (car.getMileage() <= b2)) group.addCar(car);
        }
        return group;
    }

    public Carsharing sort() {
        Carsharing group = new Carsharing(name, cars);
        Collections.sort(group.cars);
        return group;
    }

    public Carsharing sort(Comparator comp) {
        Carsharing group = new Carsharing(name, cars);
        Collections.sort(group.cars, comp);
        return group;
    }

    public void printCarsharing() {
        System.out.println(name);
        System.out.printf("%5s%8s%11s%13s%13s%15s%16s\n",
                "Number", "id", "Mark", "Typ Car", "Mileage", "Cost per Hour", "Max time rent");
        int i = 1;
        for (Car car : cars) {
            System.out.printf(" %5d %9s %10s %12s %8.2f %12.2f %11d\n",
                    i, car.getId(), car.getMark(), car.getTyp(),
                    car.getMileage(), car.getCostInHour(), car.getMaxTime());
            i++;
        }
    }

    public void updateId(String id, String newId) {
        if (newId.equals(id)) return;
        if (getCar(newId)!= null) return;
        getCar(id).setId(newId);
    }

    public void delMoreThanAvgCost() {
        double avg = avgCostPerHour();
        cars.removeIf(car -> car.getCostInHour() < avg);
    }
    /* removeIf() используется для удаления всех элементов ArrayList,
    который удовлетворяет заданному фильтру предикатов,
    который передается в качестве параметра в метод.
    предикат - это функциональный интерфейс,
    который проверяет заданный вход для заданного условия
    и возвращает логический результат для того же самого,
    указывая, было ли условие выполнено или нет.*/

    public Carsharing checkFirstLetters(String Letter) {
        Carsharing newCar = new Carsharing(
                String.format("Car with Id beginning %s ", Letter));
        Iterator<Car> iter = cars.iterator();
        while (iter.hasNext()) {
            Car car = iter.next();
            if (car.getId().startsWith(Letter)) newCar.addCar(car);
        }
        return newCar;
    }
}
