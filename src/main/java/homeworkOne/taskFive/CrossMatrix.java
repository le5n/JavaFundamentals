package homeworkOne.taskFive;

import java.util.Arrays;

class CrossMatrix {
    private int[][] matrix;

    void generateNewMatrixBySize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size must be positive");
        }
        matrix = new int[size][size];
    }


    int[][] doCross() {
        int size = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                }
                matrix[i][size - i - 1] = 1;
            }
        }
        return matrix.clone();
    }

    void printMatrix() {
        for (int[] aMatrix : matrix) {
            System.out.println(Arrays.toString(aMatrix));
        }
    }
}
