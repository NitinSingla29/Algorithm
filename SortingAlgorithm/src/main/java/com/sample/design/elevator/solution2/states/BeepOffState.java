package com.sample.design.elevator.solution2.states;

import com.sample.design.elevator.solution2.Elevator;

public class BeepOffState extends ElevatorState {

	public BeepOffState(Elevator elevator) {
		super(elevator);
	}

	@Override
	public void doAcion() {
		// Move elevator in up direction
	}
}
