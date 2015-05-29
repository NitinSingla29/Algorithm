package com.sample.design.elevator;

import java.util.PriorityQueue;

import com.sample.design.elevator.ElevatorState.BeepOnState;
import com.sample.design.elevator.ElevatorState.MovingUpState;

public abstract class Elevator implements StateFulObject<ElevatorState> {
	private ElevatorState currentElevatorState;
	private boolean stopped;
	private int currentFloor;

	private int currentLoad;
	private MovingDirection currentMovingDirection;

	private final int maxFloors;
	private int maxLoad;

	private final PriorityQueue<Pessanger> personsMovingDown;
	private final PriorityQueue<Pessanger> personsMovingUp;;

	public Elevator(ElevatorState currentElevatorState, int maxFloors, int currentFloor, PriorityQueue<Pessanger> personsMovingUp,
			PriorityQueue<Pessanger> personsMovingDown, int currentLoad, int maxLoad, MovingDirection currentMovingDirection) {
		super();
		this.currentElevatorState = currentElevatorState;
		this.maxFloors = maxFloors;
		this.currentFloor = currentFloor;
		this.personsMovingUp = personsMovingUp;
		this.personsMovingDown = personsMovingDown;
		this.currentLoad = currentLoad;
		this.maxLoad = maxLoad;
		this.currentMovingDirection = currentMovingDirection;
		reset();
	}

	public void beep() {
		setCurrentElevatorState(new BeepOnState(this));
		getCurrentElevatorState().doAcion();
	}

	public IState getCurrentElevatorState() {
		return currentElevatorState;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public int getCurrentLoad() {
		return currentLoad;
	}

	public MovingDirection getCurrentMovingDirection() {
		return currentMovingDirection;
	}

	public int getMaxFloors() {
		return maxFloors;
	}

	public int getMaxLoad() {
		return maxLoad;
	}

	public PriorityQueue<Pessanger> getPersonsMovingDown() {
		return personsMovingDown;
	}

	public PriorityQueue<Pessanger> getPersonsMovingUp() {
		return personsMovingUp;
	}

	public boolean isStopped() {
		return stopped;
	}

	public void move() {

	}

	public void reset() {
		currentElevatorState = new MovingUpState(this);
		personsMovingDown.clear();
		personsMovingUp.clear();
		currentFloor = 0;
	}

	public void setCurrentElevatorState(ElevatorState currentElevatorState) {
		this.currentElevatorState = currentElevatorState;
	}

	public void setCurrentLoad(int currentLoad) {
		this.currentLoad = currentLoad;
	}

	public void setCurrentMovingDirection(MovingDirection currentMovingDirection) {
		this.currentMovingDirection = currentMovingDirection;
	}

	public void setMaxLoad(int maxLoad) {
		this.maxLoad = maxLoad;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

}
