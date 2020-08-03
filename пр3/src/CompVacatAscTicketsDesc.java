import java.util.*;

public class CompVacatAscTicketsDesc implements Comparator<CampKey> {
    public int compare(CampKey cp1, CampKey cp2) {
        String vac1 = cp1.getCodeVacationer();
        String vac2 = cp2.getCodeVacationer();
        String home1 = cp1.getCodeHouse();
        String home2 = cp2.getCodeHouse();
        if (vac1.compareTo(vac2) < 0) return -1;
        if (vac1.compareTo(vac2) > 0) return 1;
        if (home1.compareTo(home2) < 0) return -1;
        if (home1.compareTo(home2) > 0) return 1;
        return 0;
    }

}
