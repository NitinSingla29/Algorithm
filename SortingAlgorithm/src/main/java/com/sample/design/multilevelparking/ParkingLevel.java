package com.sample.design.multilevelparking;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.sample.design.objectpool.AbstractObjectPool;
import com.sample.design.objectpool.IObjectPool;

public class ParkingLevel extends AbstractObjectPool<ParkingSlot> implements IObjectPool<ParkingSlot> {

	private final PriorityQueue<ParkingSlot> freeSlots;

	private final int levelNumber;
	private final int MAX_SLOTS;

	private final List<ParkingSlot> occupiedSlots;

	public ParkingLevel(int number, int totalAvailableSlots) {
		levelNumber = number;
		MAX_SLOTS = totalAvailableSlots;
		freeSlots = new PriorityQueue<>();
		occupiedSlots = new ArrayList<ParkingSlot>(totalAvailableSlots);
	}

	public int getLevelNumber() {
		return levelNumber;
	}

	@Override
	protected void clearFreeObject() {
		freeSlots.clear();
	}

	@Override
	protected void clearUsedObjects() {
		occupiedSlots.clear();
	}

	@Override
	protected void freeObject(ParkingSlot objectToFree) {
		final ParkingSlot removedSlot = occupiedSlots.remove(objectToFree.getNumber());
		if (removedSlot != null) {
			freeSlots.add(objectToFree);
		}
	}

	@Override
	protected ParkingSlot getValidFreeObject() {
		return freeSlots.poll();
	}

	@Override
	protected void refillPool() {
		for (int i = 0; i < MAX_SLOTS; i++) {
			freeSlots.add(new ParkingSlot(i));
		}
	}

}
