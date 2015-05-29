package com.sample.design.elevator.solution2;

import com.sample.design.elevator.solution2.states.IState;

public interface INextStateFindingStrategy<IS extends IState, SFO extends StateFulObject<IS>> {

	IS getNextState(SFO stateFulObject);

}
