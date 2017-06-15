package com.sample.design.elevator;


public interface INextStateFindingStrategy<IS extends IState, SFO extends StateFulObject<IS>> {

	IS getNextState(SFO stateFulObject);

}
