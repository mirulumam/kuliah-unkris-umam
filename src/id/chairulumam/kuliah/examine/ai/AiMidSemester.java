package id.chairulumam.kuliah.examine.ai;

import id.chairulumam.kuliah.examine.ai.mid.TheirToday;

import java.util.List;

public class AiMidSemester {

    public static void theirToday(List<TheirToday> list, String sa, String si) {
        for (int i = 0; i < list.size(); i++) {
            TheirToday yesterday = i == 0 ? list.get(list.size() - 1) : list.get(i - 1);
            TheirToday today = list.get(i);

            boolean santiTellsTruth = false;
            boolean sintaTellsTruth = false;

            if ( sa.equals(TheirToday.LIE) ) {
                if ( yesterday.getSanti().equals(TheirToday.LIE) ) {
                    santiTellsTruth = !today.getSanti().equals(TheirToday.LIE);
                } else {
                    santiTellsTruth = today.getSanti().equals(TheirToday.LIE);
                }
            } else if ( sa.equals(TheirToday.TRUTH) ) {
                if ( yesterday.getSanti().equals(TheirToday.TRUTH) ) {
                    santiTellsTruth = today.getSanti().equals(TheirToday.TRUTH);
                } else {
                    santiTellsTruth = today.getSanti().equals(TheirToday.LIE);
                }
            }

            if ( si.equals(TheirToday.LIE) ) {
                if ( yesterday.getSinta().equals(TheirToday.LIE) ) {
                    sintaTellsTruth = !today.getSinta().equals(TheirToday.LIE);
                } else {
                    sintaTellsTruth = today.getSinta().equals(TheirToday.LIE);
                }
            } else if ( si.equals(TheirToday.TRUTH) ) {
                if ( yesterday.getSinta().equals(TheirToday.TRUTH) ) {
                    sintaTellsTruth = today.getSinta().equals(TheirToday.TRUTH);
                } else if ( yesterday.getSinta().equals(TheirToday.LIE) ) {
                    sintaTellsTruth = today.getSinta().equals(TheirToday.LIE);
                }
            }

            if ( santiTellsTruth && sintaTellsTruth ) {
                System.out.println(today.getDay() + ": Sinta tells " + today.getSanti() + " and Santi tels " + today.getSinta());
                return;
            }
        }
    }
}
