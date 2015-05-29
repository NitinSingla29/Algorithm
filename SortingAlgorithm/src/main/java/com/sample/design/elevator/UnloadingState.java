package com.sample.design.elevator;


public class UnloadingState extends ElevatorState {

	public UnloadingState(Elevator elevator) {
		super(elevator);
	}

	@Override
	public void doAcion() {
		// Move elevator in up direction
	}
}
