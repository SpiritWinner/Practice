import java.util.*;
public class CompCodeAscLengthDesc implements Comparator {
    public int compare (Object ob1, Object ob2) {
        CityTransport citTran1 = (CityTransport) ob1;
        CityTransport citTran2 = (CityTransport) ob2;
        if (citTran1.getCodeRoute().compareTo(citTran2.getCodeRoute()) < 0) return -1;
        else if (citTran1.getCodeRoute().compareTo(citTran2.getCodeRoute()) > 0) return 1;
        else if (citTran1.getLengthRoute() < citTran2.getLengthRoute()) return 1;
        else if (citTran1.getLengthRoute() == citTran2.getLengthRoute()) return 0;
        else return -1;
    }
}