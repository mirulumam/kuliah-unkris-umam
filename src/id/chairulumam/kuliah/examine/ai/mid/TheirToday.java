package id.chairulumam.kuliah.examine.ai.mid;

public class TheirToday {

    private String day;
    private String santi;
    private String sinta;

    public static final String TRUTH = "truth";
    public static final String LIE = "lie";

    public TheirToday(String day, String sa, String si) {
        setDay(day);
        setSanti(sa);
        setSinta(si);
    }

    public String getOpposite(String s) {
        return s.equals("truth") ? "lie" : "truth";
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSanti() {
        return santi;
    }

    public void setSanti(String santi) {
        this.santi = santi;
    }

    public String getSinta() {
        return sinta;
    }

    public void setSinta(String sinta) {
        this.sinta = sinta;
    }
}
