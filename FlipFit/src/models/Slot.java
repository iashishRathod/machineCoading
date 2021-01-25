package models;

import java.util.ArrayList;
import java.util.List;

public class Slot {
	
	private int num;
	private String varition;
	private int totalSlot;
	private int freeSlot;
	List<String> bookedBy;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getVarition() {
		return varition;
	}
	public void setVarition(String varition) {
		this.varition = varition;
	}
	public int getTotalSlot() {
		return totalSlot;
	}
	public void setTotalSlot(int totalSlot) {
		this.totalSlot = totalSlot;
	}
	public int getFreeSlot() {
		return freeSlot;
	}
	public void setFreeSlot(int freeSlot) {
		this.freeSlot = freeSlot;
	}
	
	public Slot(int num, String varition, int totalSlot, int freeSlot) {
		super();
		this.num = num;
		this.varition = varition;
		this.totalSlot = totalSlot;
		this.freeSlot = freeSlot;
	}
	
	public List<String> getBookedBy() {
		if(bookedBy == null) bookedBy = new ArrayList<>();
		return bookedBy;
	}
	public void setBookedBy(List<String> bookedBy) {
		this.bookedBy = bookedBy;
	}

}
