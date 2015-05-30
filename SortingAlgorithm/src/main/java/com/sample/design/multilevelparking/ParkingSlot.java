package com.sample.design.multilevelparking;

import java.util.Date;

import com.sample.design.objectpool.IReusableObject;

public class ParkingSlot implements Comparable<ParkingSlot>, IReusableObject {

	private final int number;
	private boolean occupied;
	private Date occupiedAt;
	private final ParkingSize parkingSize;

	public ParkingSlot(int number) {
		super();
		this.number = number;
		occupied = false;
		parkingSize = ParkingSize.LARGE;
		occupiedAt = null;
	}

	public ParkingSlot(int number, boolean occupied, ParkingSize parkingSize, final Date occupiedAt) {
		super();
		this.number = number;
		this.occupied = occupied;
		this.parkingSize = parkingSize;
		this.occupiedAt = occupiedAt;
	}

	@Override
	public void close() throws Exception {
		occupied = false;
		occupiedAt = null;
	}

	@Override
	public int compareTo(ParkingSlot o) {
		return number - o.getNumber();
	}

	public int getNumber() {
		return number;
	}

	public Date getOccupiedAt() {
		return occupiedAt;
	}

	public ParkingSize getParkingSize() {
		return parkingSize;
	}

	public boolean isOccupied() {
		return occupied;
	}

	@Override
	public boolean isValid() {
		return !occupied;
	}

	@Override
	public void release() {

	}
}
