package travelingSalespersonProblem;

import java.util.ArrayList;

public class BestFirstBranchAndBound {
	private int[][] graphEdges;
	private int minLength;
	private static int INF = Integer.MAX_VALUE;
	private ArrayList<Integer> optTour;
	private int numOfVertices;
	
	public int bestFirstBranchAndBound(AdjacencyMatrix2DGraph adjacencyMatrix2DGraph,int numOfVertices){
		graphEdges = adjacencyMatrix2DGraph.getEdges();
		this.numOfVertices = numOfVertices;
		ArrayList<QueueMember> queueList = new ArrayList<QueueMember>();
		QueueMember startNode = new QueueMember();
		ArrayList<Integer> startNodeList = new ArrayList<Integer>();
		int startVertix = 0;
		startNodeList.add(startVertix);		//startNode:v
		startNode.setPath(startNodeList);
		startNode.setLevel(0);
		startNode.setBound(bound(startNode));
		queueList.add(startNode);
		minLength = INF;
		
		QueueMember preNode = new QueueMember();
		while(!queueList.isEmpty()){
			preNode = queueList.get(0);	//preNode:v
			queueList.remove(0);
			if(preNode.getBound() < minLength){
				for(int i=1;i < numOfVertices; i++){
					if(preNode.getPath().contains(i)){
						continue;
					}
					QueueMember nextNode = new QueueMember();	//nextNode:u
					ArrayList<Integer> nextNodeList = new ArrayList<Integer>();
					nextNode.setLevel(preNode.getLevel() + 1);
					nextNodeList.addAll(preNode.getPath());
					nextNodeList.add(i);
					nextNode.setPath(nextNodeList);
					if(nextNode.getLevel() == numOfVertices-2){
						for(int j=0; j<numOfVertices; j++){
							if(!nextNode.getPath().contains(j)){
								nextNode.getPath().add(j);
								break;
							}
						}
						nextNode.getPath().add(startVertix);
						int nextNodeLength = length(nextNode);
						if(nextNodeLength < minLength){
							minLength = nextNodeLength;
							optTour = nextNode.getPath();
						}
					}else{
						nextNode.setBound(bound(nextNode));
						if(nextNode.getBound() < minLength){
							boolean flag = false;
							for(int k=0; k < queueList.size(); k++){
								if(queueList.get(k).getBound() >= nextNode.getBound()){
									flag = true;
									queueList.add(k, nextNode);
									break;
								}
							}
							if(!flag){
								queueList.add(nextNode);
							}
						}
					}
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
		return length;
	}

	private int bound(QueueMember node){
		ArrayList<Integer> selectedVerticesList = node.getPath();
		int bound = 0;
		int i, j;
		if(selectedVerticesList.size() == 1){
			for(i=0; i<numOfVertices; i++){
				bound += getMinEdge(graphEdges[i]);
			}
		}else{
			for(i=0; i<numOfVertices; i++){
				if(selectedVerticesList.contains(i) && i != selectedVerticesList.get(selectedVerticesList.size()-1)){
					bound += graphEdges[i][selectedVerticesList.get(getIPostionInSelectedVerticesList(i,selectedVerticesList)+1)];
				}else if(i == selectedVerticesList.get(selectedVerticesList.size()-1)){
					ArrayList<Integer> listI = new ArrayList<Integer>();
					for(j=0; j<numOfVertices; j++){
						if(!selectedVerticesList.contains(j)){
							listI.add(graphEdges[i][j]);
						}
					}
					bound += getMinEdge(listI);
				}else{
					ArrayList<Integer> listI = new ArrayList<Integer>();
					for(j=0; j<numOfVertices; j++){
						if(j == selectedVerticesList.get(0)){
							listI.add(graphEdges[i][j]);
						}
						if(!selectedVerticesList.contains(j)){
							listI.add(graphEdges[i][j]);
						}
					}
					bound += getMinEdge(listI);
				}
			}
		}
		return bound;
	}
	
	private int getIPostionInSelectedVerticesList(int i, ArrayList<Integer> selectedVerticesList) {
		for(int j=0; j<selectedVerticesList.size(); j++){
			if(i == selectedVerticesList.get(j)){
				return j;
			}
		}
		return INF;
	}

	private int getMinEdge(ArrayList<Integer> is) {
		int minEdge = INF;
		for(int i=0; i<is.size(); i++){
			if(is.get(i) < minEdge && is.get(i) != 0){
				minEdge = is.get(i);
			}
		}
		return minEdge;
	}
	
	private int getMinEdge(int[] is) {
		int minEdge = INF;
		for(int i=0; i<is.length; i++){
			if(is[i] < minEdge && is[i] != 0){
				minEdge = is[i];
			}
		}
		return minEdge;
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
