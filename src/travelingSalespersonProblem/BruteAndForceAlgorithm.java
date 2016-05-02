package travelingSalespersonProblem;

import java.util.ArrayList;

public class BruteAndForceAlgorithm {
	
	private int[][] graphEdges;
	private int minLength;
	private static int INF = Integer.MAX_VALUE;
	private ArrayList<Integer> optTour;
	private int numOfVertices;
	
	public int bruteAndForceAlgorithm(AdjacencyMatrix2DGraph adjacencyMatrix2DGraph,int numOfVertices){
		graphEdges = adjacencyMatrix2DGraph.getEdges();
		this.numOfVertices = numOfVertices;
		ArrayList<QueueMember> queueList = new ArrayList<QueueMember>();
		QueueMember startNode = new QueueMember();
		ArrayList<Integer> startNodeList = new ArrayList<Integer>();
		int startVertix = 0;
		startNodeList.add(startVertix);
		startNode.setPath(startNodeList);
		startNode.setLevel(0);
		queueList.add(startNode);
		minLength = INF;
		
		QueueMember preNode = new QueueMember();
		while(!queueList.isEmpty()){
			preNode = queueList.get(0);
			queueList.remove(0);
			for(int i=1;i < numOfVertices; i++){
				if(preNode.getPath().contains(i)){
					continue;
				}
				QueueMember nextNode = new QueueMember();
				ArrayList<Integer> nextNodeList = new ArrayList<Integer>();
				nextNodeList.addAll(preNode.getPath());
				nextNode.setLevel(preNode.getLevel() + 1);
				nextNode.setPath(nextNodeList);
				nextNode.getPath().add(i);
				if(nextNode.getLevel() == numOfVertices-2){
					for(int j=0; j<numOfVertices; j++){
						if(!nextNode.getPath().contains(j)){
							nextNode.getPath().add(j);
						}
					}
					nextNode.getPath().add(startVertix);
					int nextNodeLength = length(nextNode);
					if(nextNodeLength < minLength){
						minLength = nextNodeLength;
						optTour = nextNode.getPath();
					}
				}else{
					queueList.add(nextNode);
				}
			}
		}
		return minLength;
	}

	private int length(QueueMember nextNode) {
		int length = 0;
		for(int i=0; i<numOfVertices; i++){
			length += graphEdges[nextNode.getPath().get(i)][nextNode.getPath().get(i+1)];
		}
//			System.out.println("length:"+length);
		return length;
	}

	
	public int[][] getGraphEdges() {
		return graphEdges;
	}
	public void setGraphEdges(int[][] graphEdges) {
		this.graphEdges = graphEdges;
	}
	public int getMinLength() {
		return minLength;
	}
	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}
	public ArrayList<Integer> getOptTour() {
		return optTour;
	}
	public void setOptTour(ArrayList<Integer> optTour) {
		this.optTour = optTour;
	}
	public int getNumOfVertices() {
		return numOfVertices;
	}
	public void setNumOfVertices(int numOfVertices) {
		this.numOfVertices = numOfVertices;
	}
}
