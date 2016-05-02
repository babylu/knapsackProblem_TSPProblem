package travelingSalespersonProblem;

import java.util.ArrayList;

public class QueueMember {
	private ArrayList<Integer> path;
	private int bound;
	private int level;
	

	public ArrayList<Integer> getPath() {
		return path;
	}
	public void setPath(ArrayList<Integer> path) {
		this.path = path;
	}
	public int getBound() {
		return bound;
	}
	public void setBound(int bound) {
		this.bound = bound;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
