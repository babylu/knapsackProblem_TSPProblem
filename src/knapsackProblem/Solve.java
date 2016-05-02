package knapsackProblem;

import java.util.ArrayList;

public class Solve {

	public static void main(String[] args) {
		KnapsackMember knapsackMember1 = new KnapsackMember(20,2);
		KnapsackMember knapsackMember2 = new KnapsackMember(30,5);
		KnapsackMember knapsackMember3 = new KnapsackMember(35,7);
		KnapsackMember knapsackMember4 = new KnapsackMember(12,3);
		KnapsackMember knapsackMember5 = new KnapsackMember(3,1);
		ArrayList<KnapsackMember> knapsackList = new ArrayList<>();
		knapsackList.add(knapsackMember1);
		knapsackList.add(knapsackMember2);
		knapsackList.add(knapsackMember3);
		knapsackList.add(knapsackMember4);
		knapsackList.add(knapsackMember5);
		
		int result;
		
		BreadthFirstBranchAndBound breasthFristBranchAndBound = new BreadthFirstBranchAndBound();
		breasthFristBranchAndBound.setKnapsack(knapsackList);
		breasthFristBranchAndBound.setMaxWeight(13);
		result = breasthFristBranchAndBound.breadthFirstBranchAndBound();
		System.out.println("The result of Breadth-First with Branch-and-Bound: " + result);
		
		BestFirstBranchAndBound bestFristBranchAndBound = new BestFirstBranchAndBound();
		bestFristBranchAndBound.setKnapsack(knapsackList);
		bestFristBranchAndBound.setMaxWeight(13);
		result = bestFristBranchAndBound.bestFirstBranchAndBound();
		System.out.println("The result of Best-First with Branch-and-Bound: " + result);

	}

}
