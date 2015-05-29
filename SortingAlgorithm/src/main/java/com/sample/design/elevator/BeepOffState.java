package com.sample.design.elevator;


public class BeepOffState extends ElevatorState {

	public BeepOffState(Elevator elevator) {
		super(elevator);
	}

	@Override
	public void doAcion() {
		// Move elevator in up direction
	}
}
