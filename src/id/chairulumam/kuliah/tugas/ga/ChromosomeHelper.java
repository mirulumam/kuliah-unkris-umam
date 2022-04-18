package id.chairulumam.kuliah.tugas.ga;

import id.chairulumam.kuliah.util.Helper;

import java.util.ArrayList;
import java.util.List;

public class ChromosomeHelper {

    private Chromosome chromosome;
    private List<Integer> list = new ArrayList<>();
    private int evaluations;
    private float fitness;
    private float probabilities;

    public ChromosomeHelper(Chromosome c) {
        chromosome = c;
        list.addAll(chromosome.getListAsInt());
        evaluations = Math.abs((list.get(0) + (2 * list.get(1)) + (3 * list.get(2)) + (4 * list.get(3))) - 30);
        fitness = Helper.round(1f / (1 + evaluations), 4);
    }

    public Chromosome getChromosome() {
        return chromosome;
    }

    public void setChromosome(Chromosome chromosome) {
        this.chromosome = chromosome;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public int getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(int evaluations) {
        this.evaluations = evaluations;
    }

    public float getFitness() {
        return fitness;
    }

    public void setFitness(float fitness) {
        this.fitness = fitness;
    }

    public float getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(float probabilities) {
        this.probabilities = probabilities;
    }
}
