package id.chairulumam.kuliah.tugas;

import id.chairulumam.kuliah.tugas.ga.Chromosome;
import id.chairulumam.kuliah.tugas.ga.ChromosomeList;

import java.util.ArrayList;
import java.util.List;

public class MyTask {

    private static void gaTask() {
        List<Chromosome> firstGen = new ArrayList<>();
        firstGen.add(new Chromosome("12", "05", "23", "08"));
        firstGen.add(new Chromosome("02", "21", "18", "03"));
        firstGen.add(new Chromosome("10", "04", "13", "14"));
        firstGen.add(new Chromosome("20", "01", "10", "06"));
        firstGen.add(new Chromosome("01", "04", "13", "19"));
        firstGen.add(new Chromosome("20", "05", "17", "01"));

        ChromosomeList currentGen = new ChromosomeList(firstGen);

        for (int i = 0; i < 5; i++) {
            System.out.println("Gen " + (i + 1) + " =================================================");
            System.out.println("RNG        : " + currentGen.getRng());
            for (int j = 0; j < 6; j++) {
                printChromosome(currentGen.getList().get(j).getList().toString());
            }
            //System.out.println("===============================================================================");
            if ( i < 4 ) {
                List<Chromosome> c = new ArrayList<>(currentGen.getMutatedGen());
                currentGen = new ChromosomeList(c);
            }
        }
    }

    private static void printChromosome(String c) {
        System.out.println("Chromosome : " + c);
    }

}
