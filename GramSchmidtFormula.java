import java.util.Scanner;

public class GramSchmidtFormula {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("How many rows?");
		final int ROWS = scnr.nextInt();
		System.out.println("How many collums?");
		final int COLLUMNS = scnr.nextInt();
		
		double[][] input = new double[ROWS][COLLUMNS];
		double[][] output = new double[ROWS][COLLUMNS];
		
		for (int c = 0; c < COLLUMNS; c++) {
			for (int r = 0; r < ROWS; r++) {
				System.out.println("What is collumn " + (c+1) + " row " + (r +1) + "?");
				input[r][c] = scnr.nextDouble();
			}
		}
		
		scnr.close();
		
		for (int r = 0; r < ROWS; r++) {
			output[r][0] = input[r][0];
		}
		
		double ratio = 0;
		
		double[] vector1 = new double[ROWS];
		double[] vector2 = new double[ROWS];
		
		for (int r = 0; r < ROWS; r++) {
			vector1[r] = input[r][1];
		}
		
		for (int r = 0; r < ROWS; r++) {
			vector2[r] = output[r][0];
		}
		
		
		//finds the ratio.
		ratio = dotProduct(vector1, vector2);
		ratio = ratio / dotProduct(vector2, vector2);
		
		// finds the output for collumn 2.
		for (int i = 0; i < ROWS; i++) {
			output[i][1] = input[i][1] - (ratio * output[i][0]);
		}
		
		// Finds the output for collumn 3.
		
		for (int i = 0; i < ROWS; i++) {
			output[i][2] = input[i][2];
		}
		
		for (int i = 0; i < ROWS; i++) {
			vector1[i] = input[i][2];
		}
		for (int i = 0; i < ROWS; i++) {
			vector2[i] = output[i][0];
		}
		
		//finds the ratio.
		ratio = dotProduct(vector1, vector2);
		ratio = ratio / dotProduct(vector2, vector2);
		
		for (int r = 0; r < ROWS; r++) {
			output[r][2] = output[r][2] - (ratio * output[r][0]);
		}
		
		
		for (int i = 0; i < ROWS; i++) {
			vector2[i] = output[i][1];
		}
		
		//finds the ratio.
		ratio = dotProduct(vector1, vector2);
		ratio = ratio / dotProduct(vector2, vector2);
		
		for (int r = 0; r < ROWS; r++) {
			output[r][2] = output[r][2] - (ratio * output[r][1]);
		}
		
		// Outputs the basis.
		for(int r = 0; r < ROWS; r++) {
			for(int c = 0; c < COLLUMNS; c++) {
				System.out.print(output[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	public static double dotProduct(double[] vector1, double[] vector2) {
		
		double answer = 0;
		
		if (vector1.length == vector2.length) {
			for (int i = 0; i < vector1.length; i++) {
				answer = answer + (vector1[i] * vector2[i]);
			}
		}
		else {
			System.out.print("The vectors are not the same size.");
		}
		
		return answer;
	}
}
