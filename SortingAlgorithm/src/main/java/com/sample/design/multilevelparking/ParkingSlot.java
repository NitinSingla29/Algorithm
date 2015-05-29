package com.sample.design.multilevelparking;

public class ParkingSlot implements Comparable<ParkingSlot> {

	private final int number;
	private final boolean occupied;
	private final ParkingSize parkingSize;

	public ParkingSlot(int number, boolean occupied, ParkingSize parkingSize) {
		super();
		this.number = number;
		this.occupied = occupied;
		this.parkingSize = parkingSize;
	}

	@Override
	public int compareTo(ParkingSlot o) {
		return number - o.getNumber();
	}

	public int getNumber() {
		return number;
	}

	public ParkingSize getParkingSize() {
		return parkingSize;
	}

	public boolean isOccupied() {
		return occupied;
	}

}
