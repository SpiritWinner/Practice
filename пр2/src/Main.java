public class Main {
    public static void main(String[] args) {
        UrbanEnterprisesSET ur1 = new UrbanEnterprisesSET("ООО Таврида-Сервис-Плюс");
        UrbanEnterprisesSET ur2 = new UrbanEnterprisesSET("ООО Автоград-Плюс");
        int j = 0;

        for (int i = 0; i < 5; i++) {
            String codeRoute = args[j];j++;
            String nameRoute = args[j];j++;
            String kindTransport = args[j];j++;
            double lengthRoute = Double.valueOf(args[j]);j++;
            int numberStops = Integer.valueOf(args[j]);j++;
            ur1.addRoute(new CityTransport(codeRoute, nameRoute, kindTransport, lengthRoute, numberStops));
        }
        for (int i = 0; i < 5; i++) {
            String codeRoute = args[j];j++;
            String nameRoute = args[j];j++;
            String kindTransport = args[j];j++;
            double lengthRoute = Double.valueOf(args[j]);j++;
            int numberStops = Integer.valueOf(args[j]);j++;
            ur2.addRoute(new CityTransport(codeRoute, nameRoute, kindTransport, lengthRoute, numberStops));
        }

        ur1.putUrbEnt();
        System.out.println("Попытка добавить маршрут: 3, Бикини-Боттом, Стромберг, 95.0, 7");
        // попытка добавить маршрут код которого уже существует
        ur1.addRoute(new CityTransport("3", "Бикини-Боттом", "Стромберг", 95.0, 7));
        ur1.putUrbEnt();
        ur1.aboveAvgLength().sortLengthAsc().putUrbEnt();
        ur1.betweenNumberStops(20, 26).sortBallDesc().putUrbEnt();
        ur1.delRoute("3а"); // удаления маршрута
        System.out.println("После удаления маршрута с кодом = 3а:");
        ur1.putUrbEnt();

        ur2.putUrbEnt();
        ur2.sortNameAscBallDesc().putUrbEnt();
        ur2.aboveAvgLength().sortLengthAsc().putUrbEnt();
        ur2.betweenNumberStops(30, 35).sortBallDesc().putUrbEnt();

        String n = "23";
        CityTransport c1 = ur1.getCityTrans(n);
        if (c1 == null) System.out.println("У предприятия " + ur1.getUrbanName() + " нет маршрута с кодом " + n);
        else System.out.println(c1);
        n = "70";
        c1 = ur1.getCityTrans(n);
        if (c1 == null) System.out.println("У предприятия " + ur1.getUrbanName() + " нет маршрута с кодом " + n);
        else System.out.println(c1);
        n = "20";
        c1 = ur2.getCityTrans(n);
        if (c1 == null) System.out.println("У предприятия " + ur2.getUrbanName() + " нет маршрута с кодом " + n);
        else System.out.println(c1);
    }
}
