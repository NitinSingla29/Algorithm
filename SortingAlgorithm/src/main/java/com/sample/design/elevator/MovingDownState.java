package com.sample.design.elevator;


public class MovingDownState extends ElevatorState {

	public MovingDownState(Elevator elevator) {
		super(elevator);
	}

	@Override
	public void doAcion() {
		// Move elevator in up direction
	}
}
