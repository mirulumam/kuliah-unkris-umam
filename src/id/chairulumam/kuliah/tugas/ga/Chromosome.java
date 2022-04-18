package id.chairulumam.kuliah.tugas.ga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chromosome {

    private List<String> list = new ArrayList<>();
    private final ChromosomeHelper helper;

    public Chromosome(String... strings) {
        list.addAll(Arrays.asList(strings));
        helper = new ChromosomeHelper(this);
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<Integer> getListAsInt() {
        if ( this.list.size() < 4 ) {
            return null;
        }
        try {
            return new ArrayList<>(
                    Arrays.asList(
                            Integer.parseInt(list.get(0)),
                            Integer.parseInt(list.get(1)),
                            Integer.parseInt(list.get(2)),
                            Integer.parseInt(list.get(3))
                    )
            );
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public ChromosomeHelper getHelper() {
        return helper;
    }
}
