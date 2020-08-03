public class Main {
    public static void main(String[] args) {
        CampRegister reg = new CampRegister("Оздоровительный лагерь \"Горизонт\"");
        int j = 0;
        for (int i = 0; i < 10; i++) {
            int tickets = Integer.valueOf(args[j]);j++;
            String vacationer = args[j];j++;
            String house = args[j];j++;
            int price = Integer.valueOf(args[j]);j++;
            reg.addCamp(new CampKey(tickets, vacationer, house), price);
        }
        System.out.println(String.format("Начальное состояние лагеря %s:", reg));
        reg.putCampRegister();
        System.out.println("\n-----------------1.Запрос на добавление записи в лагере.-----------------");
        CampKey ck = new CampKey(1515, "Студент", "Многоэтажный корпус");
        if (!reg.addCamp(ck, 10000))
            System.out.println(String.format("Запись %s\n\t нарушает правило уникальности ключа", ck));
        System.out.println("\n-----------------2.Запрос на обновление записи в лагере.-----------------");
        ck = new CampKey(1515, "Студент", "Одноэтажный коттедж");
        reg.updateCamp(ck, 30000);
        System.out.println(String.format("После обновления стоимости в записи:\n\t%s", ck));
        reg.putCampRegister();
        System.out.println("\n------------------3.Заросы на выборку записей в лагере.------------------");
        reg.selectTicketData(1515).sortVacationerAscTicketsDesc().putCampRegister();
        reg.selectTicketData(1517).sortPriceDesc().putCampRegister();
        reg.selectVacationerData("Преподаватель").sortTicketsAscHouseDesc().putCampRegister();
        reg.selectCampInPrice(10000).putCampRegister();
        System.out.println("\n------------------4.Запрос на удаление записи в лагере.------------------");
        ck = new CampKey(1500, "Преподаватель", "Многоэтажный корпус");
        reg.delCamp(ck);
        System.out.println(String.format("После удаления записи:\n\t%s", ck));
        reg.putCampRegister();
        ck = new CampKey(7500, "Студент", "Многоэтажный корпус");
        if (!reg.delCamp(ck))
            System.out.println(String.format("Попытка удаления несуществующей записи:\n\t%s", ck));
        reg.delCamp(1517);
        System.out.println("После удаления всех записей об путевке №1517");
        reg.putCampRegister();
        if (!reg.delCamp(7500))
            System.out.println(String.format("Попытка удаления путевки несуществующего клиента:%7d", 7500));
        System.out.println("\n Рассмотренная структура программы обработки базы данных (БД):");
        System.out.println("код и вызов запросов встроены в код программы,");
        System.out.println("может применяться, если список запросов к БД");
        System.out.println("ограничен и заранее известен.");
        System.out.println("В противном случае, нужно использовать возможности Java");
        System.out.println("по применению встроенного динамического SQL.");
    }
}
