package com.sample.design.elevator;


public abstract class ElevatorState implements IState {

	private final Elevator elevator;

	public ElevatorState(Elevator elevator) {
		super();
		this.elevator = elevator;
	}

	public Elevator getElevator() {
		return elevator;
	}

}
