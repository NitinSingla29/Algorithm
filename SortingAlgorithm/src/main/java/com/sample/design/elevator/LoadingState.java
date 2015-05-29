package com.sample.design.elevator;


public class LoadingState extends ElevatorState {

	public LoadingState(Elevator elevator) {
		super(elevator);
	}

	@Override
	public void doAcion() {
		// Move elevator in up direction
	}
}
