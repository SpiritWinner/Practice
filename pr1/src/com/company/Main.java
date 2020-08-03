package com.company;

public class Main {
    public static void main(String[] args) {
        Carsharing cr1 = new Carsharing("Coldencar");
        Carsharing cr2 = new Carsharing("Cardrive");
        int j = 0;

        for (int i = 0; i < 5; i++) {
            String id = args[j];j++;
            String mark = args[j];j++;
            String typ = args[j];j++;
            double mileage = Double.parseDouble(args[j]);j++;
            double costInHour = Double.parseDouble(args[j]);j++;
            int maxTime = Integer.parseInt(args[j]);j++;
            cr1.addCar(new Car(id, mark, typ, mileage, costInHour, maxTime));
        }

        for (int i = 0; i < 5; i++) {
            String id = args[j];j++;
            String mark = args[j];j++;
            String typ = args[j];j++;
            double mileage = Double.parseDouble(args[j]);j++;
            double costInHour = Double.parseDouble(args[j]);j++;
            int maxTime = Integer.parseInt(args[j]);j++;
            cr2.addCar(new Car(id, mark, typ, mileage, costInHour, maxTime));
        }

        System.out.println("Carsharing (not sorted)");
        cr1.printCarsharing();

        System.out.println("Attempt to add car: A422MP90, Honda, Электро, 15.3, 400.0, 2");
        cr1.addCar(new Car("A422MP90", "Honda", "Электро", 15.3, 400.0, 2));

        System.out.println("Carsharing (с естественным порядком сортировки)");
        cr1.sort().printCarsharing();
        System.out.println("Carsharing (с сортировкой по возрастанию балла)");
        cr1.aboveAvgCostPerHour().sort(new CompCostAsc()).printCarsharing();
        System.out.println("Carsharing (с сортировкой по убыванию балла)");
        cr1.betweenMileage(9.5, 20.0).sort(new CompCostDesc()).printCarsharing();
        cr1.delCar("P021PR66");
        System.out.println("After deleting car from id = P021PR66:");
        System.out.println("Carsharing (с естественным порядком сортировки)");
        cr1.printCarsharing();
        System.out.println("Carsharing");
        cr1.delMoreThanAvgCost();
        cr1.printCarsharing();

        System.out.println("Carsharing (с сортировкой по возрастанию номеров и убыванию цены)");
        cr2.sort(new CompIdAscCostDesc()).printCarsharing();
        System.out.println("Update car with a Id = A292YC47, on Id = A300YC47");
        cr2.updateId("A292YC47", "A300YC47");
        cr2.printCarsharing();
        System.out.println("Carsharing (с сортировкой по возрастанию балла)");
        cr2.aboveAvgCostPerHour().sort(new CompCostAsc()).printCarsharing();
        System.out.println("Carsharing (с сортировкой по убыванию балла)");
        cr2.betweenMileage(5.0, 15.0).sort(new CompCostDesc()).printCarsharing();
        cr2.checkFirstLetters("Y1").printCarsharing();
        cr2.printCarsharing();

        String n = "P021PP66";
        Car c1 = cr1.getCar(n);
        if (c1 == null) System.out.println("In Carsharing " + cr1.getGroupName() + " no car with a number " + n);
        else System.out.println(c1);
        n = "P129CT79";
        c1 = cr1.getCar(n);
        if (c1 == null) System.out.println("In Carsharing " + cr1.getGroupName() + " no car with a number " + n);
        else System.out.println(c1);
        n = "C777OK32";
        c1 = cr2.getCar(n);
        if (c1 == null) System.out.println("In Carsharing " + cr1.getGroupName() + " no car with a number " + n);
        else System.out.println(c1);
    }
}