package id.chairulumam.kuliah.tugas.ga;

import id.chairulumam.kuliah.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {

    static int min = 1;
    static int max = 1000;
    private final List<Float> list = new ArrayList<>();
    private final List<Float> sorted = new ArrayList<>();
    private final static List<String> gens = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7"));

    public RandomNumber() {
        int i = 0;
        int maxCount = 6;
        while (i < maxCount) {
            list.add(getRand());
            i++;
        }

        sorted.addAll(list);
        sorted.sort(Float::compare);
    }

    public static float getRand() {
        float f = ThreadLocalRandom.current().nextInt(min, max + 1) * 1f;
        return Helper.round(f / max, 4);
    }

    public static float getRandCrossOverRate() {
        float f = ThreadLocalRandom.current().nextInt(0, 250 + 1) * 1f;
        return Helper.round(f / max, 4);
    }

    /*
     * get random 4 gens from parent and children
     */
    public static List<Integer> getRandGen() {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        while ( gens.size() > 4 ) {
            int a = random.nextInt(gens.size());
            result.add(Integer.parseInt(gens.get(a)));
            gens.remove(gens.get(a));
        }

        return result;
    }

    public List<Float> getList() {
        return list;
    }

    public List<Float> getSorted() {
        return sorted;
    }
}
