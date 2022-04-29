package id.chairulumam.kuliah.examine;

import id.chairulumam.kuliah.examine.ai.AiMidSemester;
import id.chairulumam.kuliah.examine.ai.mid.TheirToday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyExamine {

    public static void aiMidSemester() {
        TheirToday senin = new TheirToday("Senin", TheirToday.TRUTH, TheirToday.LIE);
        TheirToday selasa = new TheirToday("Selasa", TheirToday.TRUTH, TheirToday.LIE);
        TheirToday rabu = new TheirToday("Rabu", TheirToday.TRUTH, TheirToday.LIE);
        TheirToday kamis = new TheirToday("Kamis", TheirToday.LIE, TheirToday.TRUTH);
        TheirToday jumat = new TheirToday("Jumat", TheirToday.LIE, TheirToday.TRUTH);
        TheirToday sabtu = new TheirToday("Sabtu", TheirToday.LIE, TheirToday.TRUTH);
        TheirToday minggu = new TheirToday("Minggu", TheirToday.LIE, TheirToday.LIE);

        List<TheirToday> list = new ArrayList<>(Arrays.asList(senin, selasa, rabu, kamis, jumat, sabtu, minggu));

        AiMidSemester.theirToday(list, TheirToday.LIE, TheirToday.LIE);
    }
}
