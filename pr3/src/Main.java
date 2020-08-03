public class Main {
    public static void main(String[] args) {
        DetailRegister reg = new DetailRegister("The accounting journal");
        int j = 0;
        for (int i = 0; i < 14; i++) {
            int idFirm = Integer.parseInt(args[j]);j++;
            String detail = args[j];j++;
            String date = args[j];j++;
            int numberDet = Integer.parseInt(args[j]);j++;
            reg.addFirm(new DetailKey(idFirm, detail, date), numberDet);
        }

        System.out.println(String.format("Default status of accounting journal \n%s:", reg));
        reg.putDetailRegister();
        System.out.println("\n----------1.Request for adding info about firm.----------");
        DetailKey sk = new DetailKey(7333, "номер", "31.01.20");
        if (!reg.addFirm(sk, 2))
            System.out.println(String.format("info %s\n\t hasn't unique key", sk));
        System.out.println("\n----------2.Request for updating info about firm.--------");
        sk = new DetailKey(1970, "шины", "03.12.19");
        reg.updateFirm(sk, 300);
        System.out.println(String.format("After updating count of detail in log:\n\t %s", sk));
        reg.putDetailRegister();
        System.out.println("\n--------------3.Request for info about firm.-------------");
        reg.selectFirmData(1970).sortDateilAscDateDesc().putDetailRegister();
        reg.selectFirmDaData(1703, "25.03.19").sortNumberDesc().putDetailRegister();
        reg.selectDetailData("двери").sortDateilAscDateDesc().sortNumberDesc().putDetailRegister();
        reg.selectFirmInDateDetail("25.03.19", 100).putDetailRegister();
        System.out.println("\n---------4.Request for deleting info about firm.---------");
        sk = new DetailKey(1703, "колесо", "25.03.19");
        reg.delFirm(sk);
        System.out.println(String.format("After deleting info:\n\t %s", sk));
        reg.putDetailRegister();
        sk = new DetailKey(6666, "номер", "13.05.19");
        if (!reg.delFirm(sk))
            System.out.println(String.format("Trying to delete nonexistent info:\n\t %s", sk));
        reg.delFirm(1517);
        System.out.println("After deleting firm with id 1517");
        reg.putDetailRegister();
        if (!reg.delFirm(2838))
            System.out.println(String.format("Trying to delete info about nonexistent firm: %3d", 2838));
        System.out.println("\n The structure of the database processing program discussed (DB):");
        System.out.println("code and query calls are built into the program code");
        System.out.println("can be applied if the list of DB requests");
        System.out.println("is limited and known in advance.");
        System.out.println("Otherwise, use Java capabilities ");
        System.out.println("to apply built-in dynamic SQL.");
    }
}
