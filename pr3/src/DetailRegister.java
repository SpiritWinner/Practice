import java.util.*;
public class DetailRegister {
    private final static List<Integer> NUMBER_DETAIL = Arrays.asList(100, 200, 300, 400, 500);
    private final static String DETREG_FORMAT_STRING = "\"Detail: %s, count: %d\"";
    private String name;
    private Map<DetailKey, Integer> register;

    public DetailRegister() {
        name = "";
        register = new TreeMap<DetailKey, Integer>();
    }

    public DetailRegister(String name) {
        this.name = name;
        register = new TreeMap<DetailKey, Integer>();
    }

    public DetailRegister(String name, Comparator comp) {
        this.name = name;
        register = new TreeMap<DetailKey, Integer>(comp);
    }

    public void setRegisterName(String name) {
        this.name = name;
    }

    public String getRegisterName(String name) {
        return name;
    }

    public Map<DetailKey, Integer> getRegister() {
        return register;
    }

    public String toString() {
        return String.format(DETREG_FORMAT_STRING, name, size());
    }

    public boolean addFirm(DetailKey dk, int numberDetail) {
        if (register.containsKey(dk)) return false;
        if (!NUMBER_DETAIL.contains(numberDetail)) return false;
        register.put(dk, numberDetail);
        return true;
    }

    public boolean delFirm(DetailKey dk) {
        if (register.containsKey(dk)) {
            register.remove(dk);
            return true;
        } else return false;
    }

    public boolean delFirm(int idFirm) {
        Set<Map.Entry<DetailKey, Integer>> setE = register.entrySet();
        Iterator<Map.Entry<DetailKey, Integer>> it = setE.iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry<DetailKey, Integer> keyVal = it.next();
            if (keyVal.getKey().getIdFirm() == idFirm) {
                it.remove();
                i++;
            }
        }
        if (i == 0) return false;
        return true;
    }

    public boolean updateFirm(DetailKey dk, int numberDetail) {
        if (!register.containsKey(dk)) return false;
        if (!NUMBER_DETAIL.contains(numberDetail)) return false;
        register.put(dk, numberDetail);
        return true;
    }

    public int size() {
        return register.size();
    }

    public DetailRegister selectFirmData(int idFirm) {
        DetailRegister subSpReg = new DetailRegister(String.format("%s: info of firm %7d", name, idFirm));
        Set<Map.Entry<DetailKey, Integer>> setE = register.entrySet();
        for (Map.Entry<DetailKey, Integer> keyVal : setE)
            if (keyVal.getKey().getIdFirm() == idFirm) subSpReg.register.put(keyVal.getKey(), keyVal.getValue());
        return subSpReg;
    }

    public DetailRegister selectDetailData(String date) {
        DetailRegister subSpReg = new DetailRegister(String.format("%s: info of firm %s", name, date));
        Set<Map.Entry<DetailKey, Integer>> setE = register.entrySet();
        for (Map.Entry<DetailKey, Integer> keyVal : setE)
            if (keyVal.getKey().getDetail().equals(date)) subSpReg.register.put(keyVal.getKey(), keyVal.getValue());
        return subSpReg;
    }

    public DetailRegister selectFirmDaData(int idFirm, String date) {
        DetailRegister subSpReg = new DetailRegister(String.format("%s: info of detail %1d at date %1s", name, idFirm, date));
        Set<Map.Entry<DetailKey, Integer>> setE = register.entrySet();
        for (Map.Entry<DetailKey, Integer> keyVal : setE)
            if ((keyVal.getKey().getIdFirm() == idFirm) && (keyVal.getKey().getDate().equals(date)))
                subSpReg.register.put(keyVal.getKey(), keyVal.getValue());
        return subSpReg;
    }

    public DetailRegister sortIdAscDateDesc() {
        DetailRegister subSpReg = new DetailRegister(String.format("%s:\n\tsorting by id from lower to higher & date from higher to lower", name), new CompIdAscDateDesc());
        Set<Map.Entry<DetailKey, Integer>> setE = register.entrySet();
        for (Map.Entry<DetailKey, Integer> keyVal : setE)
            subSpReg.addFirm(keyVal.getKey(), keyVal.getValue());
        return subSpReg;
    }

    public DetailRegister sortDateilAscDateDesc() {
        DetailRegister subSpReg = new DetailRegister(String.format("%s:\n\tsorting by firm name from lower to higher & date from higher to lower", name), new CompDetailAscDateDesc());
        Set<Map.Entry<DetailKey, Integer>> setE = register.entrySet();
        for (Map.Entry<DetailKey, Integer> keyVal : setE)
            subSpReg.addFirm(keyVal.getKey(), keyVal.getValue());
        return subSpReg;
    }

    public DetailRegister sortNumberDesc() {
        DetailRegister subSpReg = new DetailRegister(String.format("%s:\n\tsorting by numberDetails from higher to lower", name), new CompNumberDetailDesc(this.register));
        Set<Map.Entry<DetailKey, Integer>> setE = register.entrySet();
        for (Map.Entry<DetailKey, Integer> keyVal : setE)
            subSpReg.addFirm(keyVal.getKey(), keyVal.getValue());
        return subSpReg;
    }

    public DetailRegister selectFirmInDateDetail(String date, int number) {
        //творческое задание
        DetailRegister subSpReg = new DetailRegister(String.format("%s: info of firm %s", name, date));
        // выборка фирм с 100 деталями
        Set<Map.Entry<DetailKey, Integer>> setE = register.entrySet();
        //в заданную дату
        for (Map.Entry<DetailKey, Integer> keyVal : setE)
            if (keyVal.getKey().getDate().equals(date) && keyVal.getValue() == number)
                subSpReg.addFirm(keyVal.getKey(), keyVal.getValue());
        return subSpReg;
    }


    public void putDetailRegister() {
        System.out.println(name);
        System.out.printf("%5s%9s%12s%12s%18s\n", "Number", "id firm", "detail", "date", "Number detail");
        int i = 1;
        Set<Map.Entry<DetailKey, Integer>> setE = register.entrySet();
        for (Map.Entry<DetailKey, Integer> keyVal : setE) {
            DetailKey key = keyVal.getKey();
            System.out.printf(" %5d %8d %12s %12s %9s\n", i, key.getIdFirm(), key.getDetail(), key.getDate(), keyVal.getValue());
            i++;
        }
    }
}