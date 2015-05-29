package com.sample.design.elevator.solution2.states;

import com.sample.design.elevator.solution2.Elevator;

public class MovingUpState extends ElevatorState {

	public MovingUpState(Elevator elevator) {
		super(elevator);
	}

	@Override
	public void doAcion() {
		// Move elevator in up direction
	}
}
