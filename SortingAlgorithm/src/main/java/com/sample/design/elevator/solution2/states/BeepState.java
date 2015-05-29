package com.sample.design.elevator.solution2.states;

import com.sample.design.elevator.solution2.Elevator;

public class BeepState extends ElevatorState {

	public BeepState(Elevator elevator) {
		super(elevator);
	}

	@Override
	public void doAcion() {
		// Move elevator in up direction
	}
}
