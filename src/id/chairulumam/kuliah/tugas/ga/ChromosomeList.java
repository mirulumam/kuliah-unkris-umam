package id.chairulumam.kuliah.tugas.ga;

import id.chairulumam.kuliah.util.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChromosomeList {

    private final List<Chromosome> list = new ArrayList<>();
    private int totalGen;
    private float totalFitness;
    private final List<Float> probabilities = new ArrayList<>();
    private final List<Float> cs = new ArrayList<>();
    private final List<Float> rng = new ArrayList<>();
    private final List<Integer> parentIndex = new ArrayList<>();
    private final List<Chromosome> parents = new ArrayList<>();
    private final List<Integer> crossOverParentIndex = new ArrayList<>();
    private final List<Chromosome> crossOverParents = new ArrayList<>();
    private final float crossOverRate = 0.25f;
    private final float mutationRate = 0.15f;
    private final Random random = new Random();

    public ChromosomeList(List<Chromosome> chromosomes) {

        reset();

        rng.addAll(new RandomNumber().getList());
        list.addAll(chromosomes);
        totalFitness = calculateTotalFitness();

        for (Chromosome c : list) {
            probabilities.add(Helper.round(getProbability(c), 4));
            totalGen += c.getList().size();
        }

        for (int i = 0; i < list.size(); i++) {
            float f = 0;
            for (int j = 0; j <= i; j++) {
                f += probabilities.get(j);
            }
            cs.add(Helper.round(f, 4));
        }

        setParentIndex();
    }

    private void reset() {
        list.clear();
        totalGen = 0;
        totalFitness = 0;
        probabilities.clear();
        cs.clear();
        rng.clear();
        parentIndex.clear();
        parents.clear();
        crossOverParentIndex.clear();
        crossOverParents.clear();
    }

    private float calculateTotalFitness() {
        float f = 0;
        for (Chromosome c : list)
            f += c.getHelper().getFitness();

        return Helper.round(f, 4);
    }

    public List<Chromosome> getParents() {
        parents.clear();
        for (int i : parentIndex) {
            parents.add(list.get(i));
        }

        return parents;
    }

    public void setParents() {
        parents.clear();
        for (int i : parentIndex) {
            parents.add(list.get(i));
        }
    }

    public List<Chromosome> getCrossOverParents() {
        return crossOverParents;
    }

    public void  setCrossOverParents() {
        crossOverParents.clear();
        for (int i : crossOverParentIndex) {
            Chromosome c = parents.get(i);
            crossOverParents.add(c);
        }

        for (int i = 0; i < crossOverParents.size(); i++) {
            List<Integer> r = RandomNumber.getRandGen();
            for (int j = 0; j < r.size(); j++) {
                String s = r.get(i) < 4 ? crossOverParents.get(i).getList().get(r.get(i)) : parents.get(i).getList().get(r.get(i) - 4);
                crossOverParents.get(i).getList().set(j, s);
            }
        }
    }

    public List<Integer> getParentIndex() {
        return parentIndex;
    }

    public void setParentIndex() {
        parentIndex.clear();
        int i = 0;
        List<Float> rng = new ArrayList<>();
        while(i < list.size()) {
            rng.add(RandomNumber.getRandCrossOverRate());
            if ( rng.get(i) < crossOverRate ) {
                parentIndex.add(i);
            }
            i++;
        }

//        List<Integer> tmp = new ArrayList<>(parentIndex);
//        if ( tmp.size() < 6 ) {
//            tmp.clear();
//            setParentIndex();
//            tmp.addAll(getParentIndex());
//        }
//
//        parentIndex.clear();
//        parentIndex.addAll(tmp);

        setParents();
        setCrossOver();
    }

    public List<Integer> getCrossOver() {
        return crossOverParentIndex;
    }

    public void  setCrossOver() {
        crossOverParentIndex.clear();
        int t = parentIndex.size();
        List<String> rand = new ArrayList<>();
        int r = 0;
        while (r < t ) {
            rand.add(String.valueOf(r));
            r++;
        }
        while ( ! rand.isEmpty() ) {
            int i = random.nextInt(rand.size());
            crossOverParentIndex.add(Integer.parseInt(rand.get(i)));
            rand.remove(rand.get(i));
        }

        setCrossOverParents();
    }

    public List<Chromosome> getMutatedGen() {
        int c = (int) (totalGen * mutationRate);
        List<String> g = new ArrayList<>();
        for (int i = 0; i < totalGen; i++) {
            g.add(String.valueOf(i));
        }
        int i = 0;
        List<String> r = new ArrayList<>();
        while (i < c) {
            int a = random.nextInt(g.size());
            r.add(g.get(a));
            g.remove(String.valueOf(a));
            i++;
        }

        for (String m : r) {
            int nm = Integer.parseInt(m);
            int newGen = ThreadLocalRandom.current().nextInt(0, 31);
            String s = newGen < 10 ? "0" + newGen : String.valueOf(newGen);
            int replacedRow = nm / 4;
            int replacedIndex = ((nm % 4) == 0 ? 4 : (nm % 4)) - 1;

            getCrossOverParents()
                    .get(replacedRow)
                    .getList()
                    .set(replacedIndex, s);
        }

        return getCrossOverParents();
    }

    public float getTotalFitness() {
        return totalFitness;
    }

    private float getProbability(Chromosome c) {
        return c.getHelper().getFitness() / totalFitness;
    }

    public List<Chromosome> getList() {
        return list;
    }

    public List<Float> getProbabilities() {
        return probabilities;
    }

    public List<Float> getCs() {
        return cs;
    }

    public List<Float> getRng() {
        return rng;
    }

}
