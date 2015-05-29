package com.sample.design.elevator.solution2;

import com.sample.design.elevator.solution2.states.ElevatorState;

public class UnloadingState extends ElevatorState {

	public UnloadingState(Elevator elevator) {
		super(elevator);
	}

	@Override
	public void doAcion() {
		// Move elevator in up direction
	}
}
