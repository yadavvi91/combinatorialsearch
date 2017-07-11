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
    private boolean found;

    public Sudoku(int[] a) {
        this.a = a;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) enumerate(i);
        }
    }

    private void process(int k) {
        System.out.println("k: " + k);
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
        if (found) return;
        // process(k);
        if (k == 81) {
            found = true;
            process(k);
            return;
        }

        if (a[k] != 0) {
            enumerate(k + 1); return;
        }

        for (int r = 1; r <= 9; r++) {
            a[k] = r;
            if (!canBacktrack(k)) enumerate(k + 1);
        }

        a[k] = 0;
    }

    private boolean canBacktrack(int k) {
        // Row
        int row = k / 9;
        for (int i = row * 9; i < row * 9 + 9; i++) {
            if (i != k) {
                if (a[i] == a[k]) return true;
            }
        }
        // Column
        int column = k % 9;
        for (int i = column; i < 81; i += 9) {
            if (i != k) {
                if (a[i] == a[k]) return true;
            }
        }

        // Box
        // First find the starting point of box with 'k' in it.
        int box_row = findBoxRow(k);
        int box_column = findBoxColumn(k);
        for (int i = box_row; i < box_row + 3; i++) {
            for (int j = box_column; j < box_column + 3; j++) {
                int l = i * 9 + j;
                if (l != k) {
                    if (a[l] == a[k]) return true;
                }
            }
        }
        return false;
    }

    private int findBoxRow(int k) {
        int val = k / 9;
        int val2 = val / 3;
        return val2 * 3;
    }

    private int findBoxColumn(int k) {
        int val = k % 9;
        int val2 = val / 3;
        return val2 * 3;
    }


    public static void main(String[] args) {
        int i = 0;
        int[] a = new int[81];
        String line;

        File file = new File(Sudoku.class.getResource("board.txt").getFile());
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
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
