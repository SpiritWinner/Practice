import java.util.*;
public class DetailKey implements Comparable<DetailKey>{
    private final static String DETKEY_FORMAT_STRING = "Firm: %1d | detail: %1s | date: %1s |";
    private int idFirm;
    private String detail;
    private String date;

    public DetailKey() {
        idFirm = 0;
        detail = "";
        date = "";
    }

    public DetailKey(int idFirm, String detail, String date) {
        this.idFirm = idFirm;
        this.detail = detail;
        this.date = date;
    }

    public int getIdFirm() {
        return idFirm;
    }

    public void setIdFirm(int idFirm) {
        this.idFirm = idFirm;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString() {
        return String.format(DETKEY_FORMAT_STRING, idFirm, detail, date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailKey detailKey = (DetailKey) o;
        return idFirm == detailKey.idFirm &&
                Objects.equals(detail, detailKey.detail) &&
                Objects.equals(date, detailKey.date);
    }

    public int hashCode() {
        return 7 * (new Integer(idFirm)).hashCode()
                + 11 * detail.hashCode()
                + 13 * date.hashCode();
    }

    public int compareTo(DetailKey dk) {
        if (idFirm < dk.idFirm) return -1;
        if (idFirm > dk.idFirm) return 1;
        if (detail.compareTo(dk.detail) < 0) return -1;
        if (detail.compareTo(dk.detail) > 0) return 1;
        if (date.compareTo(dk.date) < 0) return -1;
        if (date.compareTo(dk.date) > 0) return 1;;
        return 0;
    }
}
