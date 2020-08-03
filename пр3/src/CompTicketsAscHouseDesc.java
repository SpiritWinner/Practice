import java.util.*;
public class CompTicketsAscHouseDesc implements Comparator<CampKey> {
    public int compare(CampKey cp1, CampKey cp2) {
        int id1 = cp1.getCodeTicket();
        int id2 = cp2.getCodeTicket();
        String hm1 = cp1.getCodeHouse();
        String hm2 = cp2.getCodeHouse();
        if (id1 < id2) return -1;
        if (id1 > id2) return 1;
        if (hm1.compareTo(hm2) < 0) return -1;
        if (hm1.compareTo(hm2) > 0) return 1;
        return 0;
    }
}