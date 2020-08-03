import java.util.*;
public class CompDetailAscDateDesc implements Comparator<DetailKey> {
    public int compare(DetailKey dk1, DetailKey dk2) {
        String detail1 = dk1.getDetail();
        String detail2 = dk2.getDetail();
        String date1 = dk1.getDate();
        String date2 = dk2.getDate();
        if (detail1.compareTo(detail2) < 0) return -1;
        if (detail1.compareTo(detail2) > 0) return 1;
        if (date1.compareTo(date2) < 0) return -1;
        if (date1.compareTo(date2) > 0) return 1;
        return 0;
    }
}

