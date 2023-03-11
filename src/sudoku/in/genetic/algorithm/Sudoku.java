/*

Sudoku Puzzle Solver using Genetic Algorithm
Developed by Group A
University of Liverpool
Master of Computer Science
CSCK502 Reasoning and Intelligent Systems October 2022

MIT License

Copyright (c) 2022 Khalid Younis
Copyright (c) 2022 Jose Roberto Mora Martinez
Copyright (c) 2022 Ghafer Khan

 */

package sudoku.in.genetic.algorithm;

import java.util.Vector;

public class Sudoku {

    private static int[] initialGene;
    private int[] gene;
    private int fitnessValue;
    private double probability;

    public Sudoku(int[] gene) {
        this.gene = gene;
        fitnessValue = fitness();

    }

    public static Sudoku bestSelection(Vector<Sudoku> sudokus) {
        // Initialize the minimum sudoku to the first element in the input list
        Sudoku min = sudokus.firstElement();

        // Loop through each sudoku in the input list
        for (Sudoku sudoku : sudokus) {
            // If the current sudoku has a lower fitness value than the current minimum,
            // update the minimum sudoku to the current one
            if (sudoku.fitnessValue < min.fitnessValue) {
                min = sudoku;
            }
        }

        // Return the minimum sudoku
        return min;
    }

    public static Sudoku rouletteSelection(Vector<Sudoku> sudokus) {

        // Find the maximum fitness value among the input sudokus
        int max = 0;
        for (Sudoku sudoku : sudokus) {
            if (sudoku.fitnessValue > max) {
                max = sudoku.fitnessValue;
            }
        }

        // Calculate the sum of the differences between the maximum fitness value and each sudoku's fitness value
        int sum = 0;
        for (Sudoku sudoku : sudokus) {
            sum += max - sudoku.fitnessValue;
        }

        // Set the probability of each sudoku based on its fitness value relative to the sum of differences
        for (Sudoku sudoku : sudokus) {
            sudoku.setProbability((max - sudoku.fitnessValue) / (sum * 1.0));
        }

        // Generate a random number between 0 and the sum of differences
        double random = Math.random() * sum;

        // Loop through the sudokus and decrement the random number by the sudoku's probability until it reaches 0
        int i;
        for (i = 0; i < sudokus.size() && random > 0; i++) {
            random -= max - sudokus.get(i).fitnessValue;
        }

        // Return the last sudoku that was considered before the random number reached 0
        return sudokus.get(i - 1);
    }

    public void randomMutation() {
        int[] mutation = GeneticOperators.randomMutation(this.getGene());
        this.setGene(mutation);
    }

    public void mutation() {
        int[] mutation = GeneticOperators.mutation(this.getGene());
        this.setGene(mutation);
    }

    public void mutation(int index, int value) {
        int[] mutation = GeneticOperators.mutation(this.getGene(), index, value);
        this.setGene(mutation);
    }

    public static void randomMutation(Sudoku sudoku) {
        int[] mutation = GeneticOperators.randomMutation(sudoku.getGene());
        sudoku.setGene(mutation);
    }

    public static void mutation(Sudoku sudoku) {
        int[] mutation = GeneticOperators.mutation(sudoku.getGene());
        sudoku.setGene(mutation);
    }

    public static void mutation(Sudoku sudoku, int index, int value) {
        int[] mutation = GeneticOperators.mutation(sudoku.getGene(), index, value);
        sudoku.setGene(mutation);
    }

    public void crossover(Sudoku sudoku1, boolean singlePoint) {
        int[][] crossover = GeneticOperators.crossover(this.getGene(), sudoku1.getGene(), singlePoint);
        this.setGene(crossover[0]);
        sudoku1.setGene(crossover[1]);
    }

    public void crossover(Sudoku sudoku1) {
        int[][] crossover = GeneticOperators.crossover(this.getGene(), sudoku1.getGene());
        this.setGene(crossover[0]);
        sudoku1.setGene(crossover[1]);
    }

    public void crossover(Sudoku sudoku1, int start, int end) {
        int[][] crossover = GeneticOperators.crossover(this.getGene(), sudoku1.getGene(), start, end);
        this.setGene(crossover[0]);
        sudoku1.setGene(crossover[1]);
    }

    public static void crossover(Sudoku sudoku, Sudoku sudoku1, boolean singlePoint) {
        int[][] crossover = GeneticOperators.crossover(sudoku.getGene(), sudoku1.getGene(), singlePoint);
        sudoku.setGene(crossover[0]);
        sudoku1.setGene(crossover[1]);
    }

    public static void crossover(Sudoku sudoku, Sudoku sudoku1) {
        int[][] crossover = GeneticOperators.crossover(sudoku.getGene(), sudoku1.getGene());
        sudoku.setGene(crossover[0]);
        sudoku1.setGene(crossover[1]);
    }

    public static void crossover(Sudoku sudoku, Sudoku sudoku1, int start, int end) {
        int[][] crossover = GeneticOperators.crossover(sudoku.getGene(), sudoku1.getGene(), start, end);
        sudoku.setGene(crossover[0]);
        sudoku1.setGene(crossover[1]);
    }

    public int fitness() {
        return fitness(this.gene);
    }

    public static int fitness(int[] gene) {
        int fitness = 0;
        int[][] newGene = oneDToTwoD(gene);
        int[][] newInitialGene = oneDToTwoD(initialGene);
        for (int i = 0; i < newGene.length; i++) {
            boolean[] rowFlag = new boolean[newGene.length + 1];
            boolean[] colFlag = new boolean[newGene.length + 1];
            for (int j = 0; j < newGene.length; j++) {
                if (rowFlag[newGene[i][j]]) {
                    fitness++;
                }
                if (colFlag[newGene[j][i]]) {
                    fitness++;
                }
                if ((newInitialGene[i][j] != 0 && newInitialGene[i][j] != newGene[i][j]) || newGene[i][j] == 0) {
                    fitness += 1000;
                }
                rowFlag[newGene[i][j]] = true;
                colFlag[newGene[j][i]] = true;
            }
        }
        int blockSize = (int) Math.sqrt(newGene.length);
        for (int i = 0; i < newGene.length; i += blockSize) {
            for (int j = 0; j < newGene.length; j += blockSize) {
                boolean[] blockFlag = new boolean[newGene.length + 1];

                for (int k = 0; k < blockSize; k++) {
                    for (int l = 0; l < blockSize; l++) {
                        if (blockFlag[newGene[i + k][j + l]]) {
                            fitness++;
                        }
                        blockFlag[newGene[i + k][j + l]] = true;
                    }
                }
            }
        }
        return fitness;
    }

    //The twoDToOneD method is a helper method that converts the two-dimensional representation
    //of the puzzle to a one-dimensional representation.
    //This is used for easier access to the rows, columns, and blocks of the puzzle.
    public static int[] twoDToOneD(int[][] twoD) {
        int[] oneD = new int[twoD.length * twoD.length];
        for (int i = 0; i < oneD.length; i++) {
            oneD[i] = twoD[i / twoD.length][i % twoD.length];
        }

        return oneD;
    }

    //The oneDToTwoD method is a helper method that converts the one-dimensional representation
    //of the puzzle to a two-dimensional representation.
    //This is used for easier access to the rows, columns, and blocks of the puzzle.
    public static int[][] oneDToTwoD(int[] oneD) {
        int[][] twoD = new int[(int) Math.sqrt(oneD.length)][(int) Math.sqrt(oneD.length)];
        for (int i = 0; i < oneD.length; i++) {
            twoD[i / twoD.length][i % twoD.length] = oneD[i];
        }

        return twoD;
    }

    public static int[] getInitialGene() {
        return initialGene;
    }

    public static void setInitialGene(int[] initialGene) {
        Sudoku.initialGene = initialGene;
    }

    public int[] getGene() {
        return gene;
    }

    public void setGene(int[] gene) {
        this.gene = gene;
        fitnessValue = fitness();
    }

    public int getFitnessValue() {
        return fitnessValue;
    }

    public void setFitnessValue(int fitnessValue) {
        this.fitnessValue = fitnessValue;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    @Override
    public String toString() {
        String string = "";
        int dimensions = (int) Math.sqrt(gene.length);
        for (int i : gene) {
            string += i;
        }
        for (int i = 0; i < gene.length; i++) {
            string += ((i % dimensions == 0) ? "\n" : "") + gene[i] + " ";
        }
        string += "\nFitness: " + fitnessValue + "\n";

        return string;
    }
}
