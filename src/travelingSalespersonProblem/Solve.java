package travelingSalespersonProblem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Solve {

	public static void main(String[] args) {
		System.out.println("Please decide which part you want to look(1-TestCase 2-RandomGraph):");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n == 1){
			testCase();
		}else if(n == 2){
			RandomGraph();
		}else{
			System.out.println("Input Error!");
		}
		

	}
	
	
	
	
	private static void RandomGraph() {
		System.out.println("Please input the number of vertices:");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		AdjacencyMatrix2DGraph adjacencyMatrix2DGraph = new AdjacencyMatrix2DGraph();
		adjacencyMatrix2DGraph.GraphGenerator(n);
		System.out.println("Adjacency 2-D matrix:");
		printMatrixInLine(adjacencyMatrix2DGraph.getEdges(), n);
		
		BruteAndForceAlgorithm bruteAndForceAlgorithm = new BruteAndForceAlgorithm();
		Date date1 = new Date();
		bruteAndForceAlgorithm.bruteAndForceAlgorithm(adjacencyMatrix2DGraph,n);
		Date date2 = new Date();
		System.out.println("The minLength of Brute-Force with Branch-and-Bound: " + bruteAndForceAlgorithm.getMinLength());
		System.out.print("The path of Brute-Force with Branch-and-Bound: ");
		printArrayListInLine(bruteAndForceAlgorithm.getOptTour(),n);
		
		long bruteAndForceTime = date2.getTime() - date1.getTime();
		System.out.println("Brute-Force Algorithm take time:"+bruteAndForceTime+" ms");
		
		BestFirstBranchAndBound bestFirstBranchAndBound = new BestFirstBranchAndBound();
		Date date3 = new Date();
		bestFirstBranchAndBound.bestFirstBranchAndBound(adjacencyMatrix2DGraph,n);
		Date date4 = new Date();
		System.out.println("The minLength of Best-First with Branch-and-Bound: " + bestFirstBranchAndBound.getMinLength());
		System.out.print("The path of Best-First with Branch-and-Bound: ");
		printArrayListInLine(bestFirstBranchAndBound.getOptTour(),n);

		long bestFirstTime = date4.getTime() - date3.getTime();
		System.out.println("Best-First Algorithm take time:"+bestFirstTime+" ms");

	}




	private static void testCase() {
		AdjacencyMatrix2DGraph adjacencyMatrix2DGraph = new AdjacencyMatrix2DGraph();
		int[][] edge = {{0,7,4,5,2},{9,0,8,3,3},{7,2,0,5,2},{8,1,3,0,9},{5,7,1,9,0}};
		int n = 5;
		adjacencyMatrix2DGraph.setEdges(edge);
		System.out.println("Adjacency 2-D matrix:");
		printMatrixInLine(adjacencyMatrix2DGraph.getEdges(), n);
		
		BruteAndForceAlgorithm bruteAndForceAlgorithm = new BruteAndForceAlgorithm();
		bruteAndForceAlgorithm.bruteAndForceAlgorithm(adjacencyMatrix2DGraph,n);
		System.out.println("The minLength of Brute-Force with Branch-and-Bound: " + bruteAndForceAlgorithm.getMinLength());
		System.out.print("The path of Brute-Force with Branch-and-Bound: ");
		printArrayListInLine(bruteAndForceAlgorithm.getOptTour(),n);

		BestFirstBranchAndBound bestFirstBranchAndBound = new BestFirstBranchAndBound();
		bestFirstBranchAndBound.bestFirstBranchAndBound(adjacencyMatrix2DGraph,n);
		System.out.println("The minLength of Best-First with Branch-and-Bound: " + bestFirstBranchAndBound.getMinLength());
		System.out.print("The path of Best-First with Branch-and-Bound: ");
		printArrayListInLine(bestFirstBranchAndBound.getOptTour(),n);
	}




	private static void printMatrixInLine(int[][] matrix,int n) {
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if (matrix[i][j] == Integer.MAX_VALUE){
					System.out.print('#'+",");
				}else{
					System.out.print(matrix[i][j]+",");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void printArrayListInLine(ArrayList<Integer> arraylist,int n) {
		for(int i=0;i<n;i++){
			System.out.print(arraylist.get(i));
			System.out.print('-'+">");
		}
		System.out.print(arraylist.get(n));
		System.out.println();
	}
}
