package com.company;


import java.io.IOException;

public class Life {

    public static final int HEIGHT = 16;
    public static final int WEIGHT = 16;


    public static void main(String[] args) throws InterruptedException, IOException {
        boolean[][] initialLife = new boolean[HEIGHT][WEIGHT];

        initialLife[0][1] = true;
        initialLife[1][2] = true;
        initialLife[2][0] = true;
        initialLife[2][1] = true;
        initialLife[2][2] = true;

        show(initialLife);
        runLife(initialLife);
    }

    private static void runLife(boolean[][] a) throws InterruptedException, IOException {
        while (true) {
            boolean[][] b = new boolean[HEIGHT][WEIGHT];
            evolve(a, b);
            show(b);
            a = b;
            Thread.sleep(100);
        }
    }


    private static void evolve(boolean[][] a, boolean[][] b) {
        int n;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WEIGHT; j++) {
                n = countNeighbors(i, j, a);
                if (a[i][j]) {
                    b[i][j] = !(n < 2 || n > 3);
                } else {
                    b[i][j] = (n == 3);
                }
            }
        }
    }


    private static int countNeighbors(int y, int x, boolean[][] a) {
        int result = 0;
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (i >= 0 && i < HEIGHT && j >= 0 && j < WEIGHT && a[i][j])
                    result++;
            }
        }
        return a[y][x] ? --result : result;
    }

    private static void show(boolean[][] a) {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WEIGHT; j++) {
                System.out.print(a[i][j] ? '*' : ' ');
            }
            System.out.println();
        }
    }
}
