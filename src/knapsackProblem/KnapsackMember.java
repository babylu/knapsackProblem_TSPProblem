package knapsackProblem;

public class KnapsackMember {
	private int price;
	private int weight;
	private float pricePerWeight;

	
	public KnapsackMember(int price,int weight){
		this.price = price;
		this.weight = weight;
		if(weight == 0){
			this.pricePerWeight = 0;
		}else{
			this.pricePerWeight = price/weight;
		}
	}
	
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public float getPricePerWeight() {
		return pricePerWeight;
	}
	public void setPricePerWeight(float pricePerWeight) {
		this.pricePerWeight = pricePerWeight;
	}
}
