package com.sample.design.elevator.solution2;

import java.util.PriorityQueue;

import com.sample.design.elevator.solution2.states.BeepState;
import com.sample.design.elevator.solution2.states.IState;
import com.sample.design.elevator.solution2.states.MovingUpState;

public abstract class Elevator {
	IState currentElevatorState;

	private int currentFloor;

	private int currentLoad;
	private MovingDirection currentMovingDirection;

	private final int maxFloors;
	private int maxLoad;

	private final PriorityQueue<Pessanger> personsMovingDown;
	private final PriorityQueue<Pessanger> personsMovingUp;;

	public Elevator(IState currentElevatorState, int maxFloors, int currentFloor, PriorityQueue<Pessanger> personsMovingUp,
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
		setCurrentElevatorState(new BeepState(this));
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

	public void move() {

	}

	public void reset() {
		currentElevatorState = new MovingUpState(this);
		personsMovingDown.clear();
		personsMovingUp.clear();
		currentFloor = 0;
	}

	public void setCurrentElevatorState(IState currentElevatorState) {
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

}
