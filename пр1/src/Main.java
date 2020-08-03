public class Main {
    public static void main(String[] args) {
        UrbanEnterprises ur1 = new UrbanEnterprises("ООО Таврида-Сервис-Плюс");
        UrbanEnterprises ur2 = new UrbanEnterprises("ООО Автоград-Плюс");
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
        System.out.println("Маршруты городского транспорта(без сортировки)");
        ur1.putUrbEnt();
        System.out.println("Попытка добавить маршрут: 3, Бикини-Боттом, Стромберг, 95.0, 7");
        ur1.addRoute(new CityTransport("3", "Бикини-Боттом", "Стромберг", 95.0, 7));
        System.out.println("Маршруты городского транспорта(с естесвенным прорядком сортировки)");
        ur1.sort().putUrbEnt();
        System.out.println("Маршруты городского транспорта(с сортировкой по возрастанию вещесвенного поля)");
        ur1.aboveAvgLength().sort(new CompLengthAsc()).putUrbEnt();
        System.out.println("Маршруты городского транспорта(с сортировкой по убыванию вещественного поля)");
        ur1.betweenLength(20, 26).sort(new CompLengthDesc()).putUrbEnt();
        ur1.delRoute("3а");
        System.out.println("После удаления маршрута с кодом = 3а:");
        System.out.println("Маршруты городского транспорта(с естесвенным прорядком сортировки)");
        ur1.putUrbEnt();
        System.out.println("Удаления маршрутов длинлй ниже среднего ");
        ur1.delMoreThanAvg();
        ur1.putUrbEnt();

        System.out.println("Маршруты городского транспорта(с сортировкой по возрастанию вещесвенного поля и убыванию вещественного поля)");
        ur2.sort(new CompNameAscLengthDesc()).putUrbEnt();
        System.out.println("Смена кода маршрута с 86, на 83");
        ur2.updateId("86", "83");
        ur2.putUrbEnt();
        System.out.println("Маршруты городского транспорта(с сортировкой по возрастанию вещесвенного поля)");
        ur2.aboveAvgLength().sort(new CompLengthAsc()).putUrbEnt();
        System.out.println("Маршруты городского транспорта(с сортировкой по убыванию вещественного поля)");
        ur2.betweenLength(30, 35).sort(new CompLengthDesc()).putUrbEnt();

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