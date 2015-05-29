package com.sample.design.elevator.solution2.states;

import com.sample.design.elevator.solution2.Elevator;

public class BeepOnState extends ElevatorState {

	public BeepOnState(Elevator elevator) {
		super(elevator);
	}

	@Override
	public void doAcion() {
		// Move elevator in up direction
	}
}
