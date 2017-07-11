package org.yadavvi.backtracking;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by vishal on 11/7/17.
 */
@RunWith(JUnitParamsRunner.class)
public class SudokuTest {

    private Sudoku sudoku;

    public Object[] inputOutputFiles() {
        return new Object[]{
                new Object[]{"board_input0.txt", "board_output0.txt"},
                new Object[]{"board_input1.txt", "board_output1.txt"},
        };
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    @Parameters(method = "inputOutputFiles")
    public void sudokuOutput(String inputFile, String outputFile) {
        int[] input = getDataFromFile(inputFile);
        int[] output = getDataFromFile(inputFile);

        sudoku = new Sudoku(input);
    }

    private int[] getDataFromFile(String inputFile) {
        int i = 0;
        int[] a = new int[81];
        String line;

        File file = new File(SudokuTest.class.getResource(inputFile).getFile());
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                String[] b = line.split(" ");
                for (String val : b) {
                    a[i++] = Integer.valueOf(val);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }

}