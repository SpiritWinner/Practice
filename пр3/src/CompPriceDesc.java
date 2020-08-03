import java.util.*;
public class CompPriceDesc implements Comparator<CampKey> {
    Map<CampKey, Integer> registr;

    public CompPriceDesc(Map<CampKey, Integer> registr) {
        this.registr = registr;
    }

    public int compare(CampKey cp1, CampKey cp2) {
        int price1 = registr.get(cp1);
        int price2 = registr.get(cp2);
        if (price1 > price2) return -1;
        return 1;
    }
}
