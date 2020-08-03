public class Main {
    public static void main (String[] args){
        Carsharing gr1 = new Carsharing("Coldencar");
        Carsharing gr2 = new Carsharing("Cardrive");

        int j = 0;
        for (int i = 0; i < 5; i++) {
            String id = args[j];j++;
            String mark = args[j];j++;
            String typ = args[j];j++;
            double mileage = Double.parseDouble(args[j]);j++;
            double costInHour = Double.parseDouble(args[j]);j++;
            int maxTime = Integer.parseInt(args[j]);j++;
            gr1.addCar(new Car(id, mark, typ, mileage, costInHour, maxTime));
        }

        for (int i = 0; i < 5; i++) {
            String id = args[j];j++;
            String mark = args[j];j++;
            String typ = args[j];j++;
            double mileage = Double.parseDouble(args[j]);j++;
            double costInHour = Double.parseDouble(args[j]);j++;
            int maxTime = Integer.parseInt(args[j]);j++;
            gr2.addCar(new Car(id, mark, typ, mileage, costInHour, maxTime));
        }

        gr1.printCarsharing();
        // Попытка добавить машину с номером который уже есть
        System.out.println("Attempt to add car: A422MP90, Honda, Электро, 15.3, 400.0, 2");
        gr1.addCar(new Car("A422MP90", "Honda", "Электро", 15.3, 400.0, 2));
        gr1.printCarsharing();
        gr1.aboveAvgCostPerHour().sortBallAsc().printCarsharing();
        gr1.betweenMileage(9.5,20.0).sortBallDesc().printCarsharing();
        // удаление машины по id(номеру)
        gr1.delCar("P021PP66");
        System.out.println ("After deleting car from id = P021PP66:");
        gr1.printCarsharing();

        gr2.printCarsharing();
        gr2.sortNameAscBallDesc().printCarsharing();
        gr2.aboveAvgCostPerHour().sortBallAsc().printCarsharing();
        gr2.betweenMileage(5.0,15.0).sortBallDesc().printCarsharing();

        String n = "P021PP66";
        Car s1 = gr1.getCar(n);
        if (s1 == null) System.out.println("In Carsharing " + gr1.getGroupName() + " no car with a number " + n);
        else System.out.println(s1);
        n = "P129CT79";
        s1 = gr1.getCar(n);
        if (s1 == null) System.out.println("In Carsharing " + gr1.getGroupName() + " no car with a number " + n);
        else System.out.println(s1);
        n = "C777OK32";
        s1 = gr2.getCar(n);
        if (s1 == null) System.out.println("In Carsharing " + gr1.getGroupName() + " no car with a number " + n);
        else System.out.println(s1);
    }
}