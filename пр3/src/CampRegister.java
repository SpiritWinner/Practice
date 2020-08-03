import java.util.*;

public class CampRegister {
    private final static List<Integer> PRICES = Arrays.asList(10000, 20000, 30000, 40000);
    private final static String PRICE_FORMAT_STRING = "\n\"Путевка:%s, Кол-во:%d\"";
    private String name;
    private Map<CampKey, Integer> register;

    // конструкторы
    public CampRegister() {
        name = "";
        register = new TreeMap<CampKey, Integer>();
    }

    public CampRegister(String name) {
        this.name = name;
        register = new TreeMap<CampKey, Integer>();
    }

    public CampRegister(String name, Comparator comp) {
        this.name = name;
        register = new TreeMap<CampKey, Integer>(comp);
    }

    // сеттер
    public void setRegisterName(String name) {
        this.name = name;
    }

    // геттер
    public String getRegisterName() {
        return name;
    }

    public Map<CampKey, Integer> getRegister() {
        return register;
    }

    public String toString() {
        return String.format(PRICE_FORMAT_STRING, name, size());
    }

    public boolean addCamp(CampKey ck, int price) {
        if ((register.containsKey(ck)) || (!PRICES.contains(price))) return false;
        register.put(ck, price); 
        return true;
    }

    public boolean delCamp(CampKey ck) {
        if (register.containsKey(ck)) {
            register.remove(ck);
            return true;
        } else return false;
    }

    public boolean delCamp(int codeTicket) {
        Set<Map.Entry<CampKey, Integer>> setE = register.entrySet();
        Iterator<Map.Entry<CampKey, Integer>> it = setE.iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry<CampKey, Integer> keyVal = it.next();
            if (keyVal.getKey().getCodeTicket() == codeTicket) {
                it.remove();
                i++;
            }
        }
        return i != 0;
    }

    public boolean updateCamp(CampKey ck, int price) {
        if (!register.containsKey(ck)) return false;
        if (!PRICES.contains(price)) return false;
        register.put(ck, price);
        return true;
    }

    public int size() {
        return register.size();
    }

    public CampRegister selectTicketData(int codeTicket) {
        CampRegister subCpReg = new CampRegister(String.format("%s: выборка по путевке %2d", name, codeTicket));
        Set<Map.Entry<CampKey, Integer>> setE = register.entrySet();
        for (Map.Entry<CampKey, Integer> keyVal : setE)
            if (keyVal.getKey().getCodeTicket() == codeTicket)
                subCpReg.register.put(keyVal.getKey(), keyVal.getValue());
        return subCpReg;
    }

    public CampRegister selectVacationerData(String codeVacationer) {
        CampRegister subCpReg = new CampRegister(String.format("%s: выборка по отдыхающему %s", name, codeVacationer));
        Set<Map.Entry<CampKey, Integer>> setE = register.entrySet();
        for (Map.Entry<CampKey, Integer> keyVal : setE)
            if (keyVal.getKey().getCodeVacationer().equals(codeVacationer))
                subCpReg.register.put(keyVal.getKey(), keyVal.getValue());
        return subCpReg;
    }

    public CampRegister selectVacationerHouse(int codeTickets, String codeHouse) {
        CampRegister subCpReg = new CampRegister(String.format("%s: выборка по путевке%d и жилью %s", name, codeTickets, codeHouse));
        Set<Map.Entry<CampKey, Integer>>setE = register.entrySet();
        for (Map.Entry<CampKey, Integer> keyVal : setE)
            if ((keyVal.getKey().getCodeTicket() == codeTickets) && (keyVal.getKey().getCodeHouse().equals(codeHouse)))
                subCpReg.register.put(keyVal.getKey(), keyVal.getValue());
        return subCpReg;
    }

    public CampRegister sortTicketsAscHouseDesc() {
        CampRegister subCpReg = new CampRegister(String.format("%s:\n\t" +
                "сортировка по возрастранию цены на путевку и убыванию типа жилья ", name), new CompPriceDesc(this.register));
        Set<Map.Entry<CampKey, Integer>> setE = register.entrySet();
        for (Map.Entry<CampKey, Integer> keyVal : setE)
            subCpReg.addCamp(keyVal.getKey(), keyVal.getValue());
        return subCpReg;
    }

    public CampRegister sortVacationerAscTicketsDesc() {
        CampRegister subCpReg = new CampRegister(String.format("%s:\n\t" +
                " сортировка по возрастанию шифра отдыхающего и убыванию номера дома", name), new CompVacatAscTicketsDesc());
        Set<Map.Entry<CampKey, Integer>> setE = register.entrySet();
        for (Map.Entry<CampKey, Integer> keyVal : setE)
            subCpReg.addCamp(keyVal.getKey(), keyVal.getValue());
        return subCpReg;
    }

    public CampRegister sortPriceDesc() {
        CampRegister subCpReg = new CampRegister(String.format("%s:\n\t " +
                "сортировка по убыванию номера дома", name), new CompTicketsAscHouseDesc());
        Set<Map.Entry<CampKey, Integer>> setE = register.entrySet();
        for (Map.Entry<CampKey, Integer> keyVal : setE)
            subCpReg.addCamp(keyVal.getKey(), keyVal.getValue());
        return subCpReg;
    }

    public void putCampRegister() {
        System.out.println(name);
        System.out.printf("%5s|%11s|%19s|%20s    |%9s|\n",
                "Номер","Код путевки", "Шифр отдыхающего", "Тип жилья", "Стоимость");
        System.out.println("-------------------------------------------------------------------------");
        int i = 1;
        Set<Map.Entry<CampKey, Integer>> setE = register.entrySet();
        for (Map.Entry<CampKey, Integer> keyVal : setE) {
            CampKey key = keyVal.getKey();
            System.out.printf(" %3d | %9d | %17s | %22s | %7d |\n", i, key.getCodeTicket(),
                    key.getCodeVacationer(), key.getCodeHouse(), keyVal.getValue());
            i++;
        }
    }

    public CampRegister selectCampInPrice(int prices) {
        //творческое задание, выборка путёвки с заданной ценой
        CampRegister subSpReg = new CampRegister(String.format("%s: Путевки со стоимостью =  %d", name, prices));
        Set<Map.Entry<CampKey, Integer>> setE = register.entrySet();
        for (Map.Entry<CampKey, Integer> keyVal : setE)
            if (keyVal.getValue() == prices)
                subSpReg.addCamp(keyVal.getKey(), keyVal.getValue());
        return subSpReg;
    }
}