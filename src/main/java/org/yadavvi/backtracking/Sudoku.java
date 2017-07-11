package org.yadavvi.backtracking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * NOTE: This is from Bob Sedgewick's http://algs4.cs.princeton.edu/home/ course
 * and is copyrighted to him and Kevin Wayne under GPLv3.
 */
public class Sudoku {

    private int[] a;

    public Sudoku(int[] a) {
        this.a = a;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) enumerate(i);
        }
    }

    private void process() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i > 0 && i % 9 != 0) {
                builder.append(a[i]).append(" ");
            } else {
                builder.append("\n").append(a[i]).append(" ");
            }
        }
        builder.append("\n");
        System.out.println(builder.toString());
    }

    private void enumerate(int k) {
        if (k == 81) {
            process();
            return;
        }

        if (a[k] != 0) {
            enumerate(k + 1); return;
        }

        for (int r = k; r <= 9; r++) {
            a[k] = r;
            if (!canBacktrack(k)) enumerate(k + 1);
        }

        a[k] = 0;
    }

    private boolean canBacktrack(int k) {
        // Row
        int row = k / 9;
        int start_of_row = k * row;
        for (int i = start_of_row; i < k; i++) {
            if (a[i] == a[k]) return true;
        }
        // Column
        int row_of_column = k < 9 ? k : k / 9;
        int start_of_column = row_of_column % 9;
        for (int i = start_of_column; i < k; i += 9) {
            if (a[i] == a[k]) return true;
        }

        // Box
        // First find the starting point of box with 'k' in it.
        int box_row = findBoxRow(k);
        int box_column = findBoxColumn(k);
        int start = 9 * 3 * box_row + 9 * box_column;
        for (int i = start; i < k; i++) {
            if (a[i] == a[k]) return true;
        }
        return false;
    }

    private int findBoxRow(int k) {
        int val = k / 9;
        int val2 = val / 3;
        return val2;
    }

    private int findBoxColumn(int k) {
        int val = k < 9 ? k : k / 9;
        int val2 = val % 3;
        return val2;
    }


    public static void main(String[] args) {
        int i = 0;
        int[] a = new int[81];
        String line;

        File file = new File(Sudoku.class.getResource("board.txt").getFile());
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
                String[] b = line.split(" ");
                for (String val : b) {
                    a[i++] = Integer.valueOf(val);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        Sudoku sudoku = new Sudoku(a);
    }

}
