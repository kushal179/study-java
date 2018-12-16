package study;

public class MatrixPrac {

	/**
	 * @param args
	 */

	static void printMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				System.out.print(matrix[row][col] + "\t");
			}
			System.out.print("\n");
		}
	}

	static void setRowZeros(int[][] matrix, int rowIdx) {
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[rowIdx][i] = 0;
		}
	}

	static void setColZeros(int[][] matrix, int colIdx) {
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[i][colIdx] = 0;
		}
	}

	static void setZeros(int[][] matrix) {
		boolean hasRowZeros[] = new boolean[matrix.length];
		boolean hasColZeros[] = new boolean[matrix[0].length];

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == 0) {
					hasRowZeros[row] = true;
					hasColZeros[row] = true;
				}
			}
		}

		for (int i = 0; i < hasRowZeros.length; i++) {
			if (hasRowZeros[i]) {
				setRowZeros(matrix, i);
			}
		}

		for (int i = 0; i < hasColZeros.length; i++) {
			if (hasColZeros[i]) {
				setColZeros(matrix, i);
			}
		}

	}

	public static void main(String[] args) {
		int matrix[][] = new int[4][4];

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				matrix[row][col] = row * 3 + col;
			}
		}
		
		MatrixPrac.printMatrix(matrix);
		MatrixPrac.setZeros(matrix);
		System.out.println("Matrix After Setting Zeros");
		MatrixPrac.printMatrix(matrix);
	}

}
