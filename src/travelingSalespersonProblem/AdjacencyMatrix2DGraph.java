package travelingSalespersonProblem;

import java.util.ArrayList;
import java.util.Random;


/**
 * @author babylu
 *
 */

public class AdjacencyMatrix2DGraph {
	private ArrayList<Integer> vertices = new ArrayList<Integer>();
	private int[][] edges;
	Random random = new Random();
	
	/**
	 * Generate the 2D Adjacency Matrix Graph
	 * @param n
	 */
	public void GraphGenerator(int n){
		edges = twoDMatrixGenerator(n);
		for (int i = 0; i < n; i++){
			vertices.add(i);
		}
	}
	
	/**
	 * Generate random 2D Matrix as a set of edge in a complete graph
	 * @param n
	 * @return edgeMatrix
	 */
	public int[][] twoDMatrixGenerator(int n) {
 		int[][] matrix = new int[n][n];
 		
		for(int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix.length; j++){
				if(i != j){
					matrix[i][j] = random.nextInt(9)+1;
				}
			}
		}
		return matrix;
	}



	public ArrayList<Integer> getVertices() {
		return vertices;
	}
	public void setVertices(ArrayList<Integer> vertices) {
		this.vertices = vertices;
	}
	public int[][] getEdges() {
		return edges;
	}
	public void setEdges(int[][] edges) {
		this.edges = edges;
	}
}
