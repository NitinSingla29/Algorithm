package com.sample.design.multilevelparking;

import java.util.PriorityQueue;

public class ParkingLevel {

	private int number;

	private int totalAvailableSlots;

	private PriorityQueue<ParkingSlot> freeSlots;

	private ParkingSlot[] occupiedSlots;

	public ParkingLevel(int number, int totalAvailableSlots) {
		super();
		this.number = number;
		this.totalAvailableSlots = totalAvailableSlots;
		freeSlots = new PriorityQueue<>();
		occupiedSlots = new ParkingSlot[totalAvailableSlots];
	}

	public PriorityQueue<ParkingSlot> getFreeSlots() {
		return freeSlots;
	}

	public int getNumber() {
		return number;
	}

	public ParkingSlot[] getOccupiedSlots() {
		return occupiedSlots;
	}

	public int getTotalAvailableSlots() {
		return totalAvailableSlots;
	}

	public void setFreeSlots(PriorityQueue<ParkingSlot> freeSlots) {
		this.freeSlots = freeSlots;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setOccupiedSlots(ParkingSlot[] occupiedSlots) {
		this.occupiedSlots = occupiedSlots;
	}

	public void setTotalAvailableSlots(int totalAvailableSlots) {
		this.totalAvailableSlots = totalAvailableSlots;
	}
}
