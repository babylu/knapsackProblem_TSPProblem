package knapsackProblem;

public class QueueMember {
	private int profit;
	private int weight;
	private float bound;
	private int level;
	
	public QueueMember(int profit, int weight, int level){
		this.profit = profit;
		this.weight = weight;
		this.level = level;
	}
	
	
	
	
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public float getBound() {
		return bound;
	}
	public void setBound(float bound) {
		this.bound = bound;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
