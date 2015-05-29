package com.sample.design.elevator;


public class MovingUpState extends ElevatorState {

	public MovingUpState(Elevator elevator) {
		super(elevator);
	}

	@Override
	public void doAcion() {
		// Move elevator in up direction
	}
}
