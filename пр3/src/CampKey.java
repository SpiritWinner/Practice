public class CampKey implements Comparable<CampKey> {
    // сущность- отдых в Лагере
    // формат записи об Отдыхе в лагере:
    private final static String REXCAMP_FORMAT_STRING =
            "Путевка:%d | Отдыхающий:%s | Жилье:%s |";
    private int codeTicket; // код путевки
    private String codeVacationer; // код отдыхающего
    private String codeHouse; // код дома

    // конструктор без параметров
    public CampKey() {
        codeTicket = 0;
        codeVacationer = "";
        codeHouse = "";
    }
    // конструктор с параметрами
    public CampKey(int codeTicket, String codeVacationer, String codeHouse) {
        this.codeTicket = codeTicket;
        this.codeVacationer = codeVacationer;
        this.codeHouse = codeHouse;
    }

    // геттеры
    public int getCodeTicket() {
        return codeTicket;
    }

    public String getCodeVacationer() {
        return codeVacationer;
    }

    public String getCodeHouse() {
        return codeHouse;
    }

    // сеттеры
    public void setCodeTicket(int codeTicket) {
        this.codeTicket = codeTicket;
    }

    public void setCodeVacationer(String codeVacationer) {
        this.codeVacationer = codeVacationer;
    }

    public void setCodeHouse(String codeHouse) {
        this.codeHouse = codeHouse;
    }

    // метод toString
    public String toString() {
        return String.format(REXCAMP_FORMAT_STRING, codeTicket, codeVacationer, codeHouse);
    }

    public boolean equals(Object ob) {
        if (ob == this) return true;
        if (ob == null || getClass() != ob.getClass()) return false;
        CampKey rc = (CampKey) ob;
        return (codeTicket == rc.codeTicket) && (codeVacationer.equals(rc.codeVacationer))
                && (codeHouse.equals(rc.codeHouse));
    }

    public int hashCode() {
        return 7 * (new Integer(codeTicket)).hashCode() 
                + 11 * codeVacationer.hashCode() 
                + 13 * codeHouse.hashCode();
    }

    public int compareTo(CampKey rc) {
        if (codeTicket < rc.codeTicket) return -1;
        if (codeTicket > rc.codeTicket) return 1;
        if (codeVacationer.compareTo(rc.codeVacationer) < 0) return -1;
        if (codeVacationer.compareTo(rc.codeVacationer) > 0) return 1;
        if (codeHouse.compareTo(rc.codeHouse) < 0) return -1;
        if (codeHouse.compareTo(rc.codeHouse) > 0) return 1;
        return 0;
    }
}
