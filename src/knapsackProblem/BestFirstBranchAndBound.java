package knapsackProblem;

import java.util.ArrayList;

public class BestFirstBranchAndBound {
	private int maxWeight;
	private ArrayList<KnapsackMember> knapsack;
	private int maxProfit;
	
	public int bestFirstBranchAndBound(){
		ArrayList<QueueMember> queueList = new ArrayList<QueueMember>();
		QueueMember startNode = new QueueMember(0,0,0);
		startNode.setBound(bound(startNode));
		queueList.add(startNode);
		maxProfit = 0;
		
		QueueMember preNode = new QueueMember(0,0,0);
		while(!queueList.isEmpty()){
			preNode = queueList.get(0);
			queueList.remove(0);
			if(preNode.getBound() > maxProfit){
				QueueMember nextNode1 = new QueueMember(0,0,0);
				nextNode1.setLevel(preNode.getLevel() + 1);
				nextNode1.setWeight(preNode.getWeight() + knapsack.get(nextNode1.getLevel()-1).getWeight());
				nextNode1.setProfit(preNode.getProfit() + knapsack.get(nextNode1.getLevel()-1).getPrice());
				if(nextNode1.getWeight() <= maxWeight && nextNode1.getProfit() > maxProfit){
					maxProfit = nextNode1.getProfit();
				}
				nextNode1.setBound(bound(nextNode1));
				if(nextNode1.getBound() > maxProfit){
					queueList.add(nextNode1);
				}
				QueueMember nextNode2 = new QueueMember(0,0,0);
				nextNode2.setWeight(preNode.getWeight());
				nextNode2.setProfit(preNode.getProfit());
				nextNode2.setLevel(preNode.getLevel()+1);
				nextNode2.setBound(bound(nextNode2));
				if(nextNode2.getBound() > maxProfit){
					queueList.add(nextNode2);
				}
			}
			
		}
		
		return maxProfit;
	}
	
	private float bound(QueueMember node){
		int totWeight;
		float bound;
		int j, k;
		if(node.getWeight() >= maxWeight){
			return 0;
		}else{
			bound = node.getProfit();
			j = node.getLevel();
			totWeight = node.getWeight();
			while(j < knapsack.size() && totWeight + knapsack.get(j).getWeight() <= maxWeight){
				totWeight = totWeight + knapsack.get(j).getWeight();
				bound = bound + knapsack.get(j).getPrice();
				j++;
			}
			k = j;
			if(k < knapsack.size()){
				bound = bound + (maxWeight - totWeight) * knapsack.get(j).getPricePerWeight();
			}
			return bound;
		}
	}
	
	public int getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	public ArrayList<KnapsackMember> getKnapsack() {
		return knapsack;
	}
	public void setKnapsack(ArrayList<KnapsackMember> knapsack) {
		this.knapsack = knapsack;
	}
	public int getMaxProfit() {
		return maxProfit;
	}
	public void setMaxProfit(int maxProfit) {
		this.maxProfit = maxProfit;
	}
	
	
}
