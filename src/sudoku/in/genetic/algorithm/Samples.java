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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author khalid.kareem
 */
public class Samples {

    //Define samples
    public static String[] samplesList = new String[]{"sample_1", "sample_2", "sample_3", "sample_4"};

    //Define dictionary
    public static String[] wordsList = new String[]{"GOLD", "WOR", "LIFE"};

    public static Map<String, int[]> vars = new HashMap<>();
    //Initial placement
    /*Sample 1
     [ 0 0 W 0 ]
     [ O 0 0 0 ]
     [ 0 R 0 0 ]
     [ 0 0 D 0 ]
     */
    
    public static int[] sample_1 = {0, 0, 1, 0, 2, 0, 0, 0, 0, 3, 0, 0, 0, 0, 4, 0};

    /*Sample 2
     [ W 0 0 0 ]
     [ O 0 0 0 ]
     [ R 0 0 0 ]
     [ D 0 0 0 ]
     */
    public static int[] sample_2 = {1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0};
    
    /*Sample 3
     [ 0 W 0 0 ]
     [ 0 R 0 0 ]
     [ 0 D 0 0 ]
     [ 0 O 0 0 ]
     */
    
    public static int[] sample_3 = {0, 1, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0};

    /*Sample 4
     [ 0 0 0 0 ]
     [ W R D O ]
     [ 0 0 0 0 ]
     [ 0 0 0 0 ]
     */
    
    public static int[] sample_4 = {0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0};

    public static void getSamples() {
        vars.put("sample_1", sample_1);
        vars.put("sample_2", sample_2);
        vars.put("sample_3", sample_3);
        vars.put("sample_4", sample_4);
    }
}
