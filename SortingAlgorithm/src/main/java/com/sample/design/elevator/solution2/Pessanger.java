package com.sample.design.elevator.solution2;

/**
 * Class which stores the information about a pessanger.
 */

public class Pessanger implements Comparable<Pessanger>{
	// class-wide variable
	private static int lastUsedPersonID = 0; // last id assigned

	// instance variables
	private final int personID; // id of this person
	private final int timeEntered; // time at which this person entered the
	// system
	private int timeLeft; // time at which this person left the system
	/**
	 * Meaningful only at certain times. 0 means that no floor is currently
	 * targeted.
	 */
	private final int startingFloor; // starting floor of this person
	private final int targetFloor; // target floor of this person

	/**
	 * constructor of the class person, it takes as parameter the the starting
	 * floor, target floor and the entering time of the person being created
	 * into the system
	 */
	public Pessanger(int startingFloor, int targetFloor, int enteringTime) {
		personID = nextPersonID();
		this.startingFloor = startingFloor;
		this.targetFloor = targetFloor;
		timeEntered = enteringTime;
		timeLeft = -1;
		// end constructor
	}

	/** get the time entered for this person */
	public int getEnteringTime() {
		return timeEntered;
	}

	/** get the starting floor of this person */
	public int getStartingFloor() {
		return startingFloor;
	}

	/** get the target floor of this person */
	public int getTargetFloor() {
		return targetFloor;
	}

	/** get the Waiting time for this person */
	public int getWaitingTime() {
		if (timeLeft < 0) {
			return 0;
		}
		return timeLeft - timeEntered;
	}

	/** Set the leaving time of this person - he/she is done with transporation */
	public void setLeavingTime(int leavingTime) {
		timeLeft = leavingTime;
	}

	/**
	 * @return an integer that is a valid personID and not already in use.
	 */
	private int nextPersonID() {
		lastUsedPersonID++;
		return lastUsedPersonID;
		// end nextPersonID
	}

	@Override
	public int compareTo(Pessanger o) {
		return o.targetFloor - this.targetFloor;
	}
}
