import java.util.*;
public class CompLengthAsc implements Comparator {
    public int compare(Object ob1, Object ob2) {
        CityTransport ciTra1 = (CityTransport) ob1;
        CityTransport ciTra2 = (CityTransport) ob2;
        if (ciTra1.getLengthRoute() < ciTra2.getLengthRoute()) return 1;
        else if (ciTra1.getLengthRoute() == ciTra2.getLengthRoute()) return 0;
        else return -1;
    }
}