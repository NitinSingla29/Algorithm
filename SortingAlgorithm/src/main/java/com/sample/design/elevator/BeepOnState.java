package com.sample.design.elevator;


public class BeepOnState extends ElevatorState {

	public BeepOnState(Elevator elevator) {
		super(elevator);
	}

	@Override
	public void doAcion() {
		// Move elevator in up direction
	}
}
