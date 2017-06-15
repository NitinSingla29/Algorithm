package com.sample.design.elevator;

public class ElevatorController {

	private final Elevator elevator;

	private final INextStateFindingStrategy<ElevatorState, Elevator> nextStateFindingStrategy = new DefaultNextStateFindingStrategy();

	public ElevatorController(Elevator elevator) {
		super();
		this.elevator = elevator;
	}

	public void addPessanger(Pessanger pessanger) {
		final int currentFloor = elevator.getCurrentFloor();
		if (currentFloor - pessanger.getTargetFloor() < 0) {
			elevator.getPersonsMovingDown().add(pessanger);
		} else if (currentFloor - pessanger.getTargetFloor() < 0) {
			elevator.getPersonsMovingUp().add(pessanger);
		}
		move();
	}

	public void move() {
		nextStateFindingStrategy.getNextState(elevator).doAcion();
	}

	public void start() {
		elevator.reset();
	}

	public void stop() {

	}
}
