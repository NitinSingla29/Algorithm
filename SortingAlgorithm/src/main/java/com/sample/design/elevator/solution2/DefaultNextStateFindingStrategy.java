package com.sample.design.elevator.solution2;

import com.sample.design.elevator.solution2.states.ElevatorState;

public class DefaultNextStateFindingStrategy implements INextStateFindingStrategy<ElevatorState, Elevator> {

	@Override
	public ElevatorState getNextState(Elevator elevator) {
		return null;
	}

}
