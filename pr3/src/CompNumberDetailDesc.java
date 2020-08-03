import java.util.*;
public class CompNumberDetailDesc implements Comparator<DetailKey> {
    Map<DetailKey, Integer> register;

    public CompNumberDetailDesc(Map<DetailKey, Integer> register) {
        this.register = register;
    }

    public int compare(DetailKey dk1, DetailKey dk2) {
        int numberDet1 = register.get(dk1);
        int numberDet2 = register.get(dk2);
        if (numberDet1 > numberDet2) return -1;
        return 1;
    }
}

