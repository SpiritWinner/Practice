import java.util.*;
public class CompIdAscDateDesc implements Comparator<DetailKey> {
    public int compare(DetailKey dk1, DetailKey dk2) {
        int id1 = dk1.getIdFirm();
        int id2 = dk2.getIdFirm();
        String date1 = dk1.getDate();
        String date2 = dk2.getDate();
        if (id1 < id2) return -1;
        if (id1 > id2) return 1;
        if (date1.compareTo(date2) < 0) return -1;
        if (date1.compareTo(date2) > 0) return 1;
        return 0;
    }
}
