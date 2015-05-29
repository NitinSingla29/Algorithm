package com.sample.design.elevator;

import java.util.PriorityQueue;

public class ServiceElevator extends Elevator {

	public ServiceElevator(ElevatorState currentElevatorState, int maxFloors, int currentFloor, PriorityQueue<Pessanger> personsMovingUp,
			PriorityQueue<Pessanger> personsMovingDown, int currentLoad, int maxLoad, MovingDirection currentMovingDirection) {
		super(currentElevatorState, maxFloors, currentFloor, personsMovingUp, personsMovingDown, currentLoad, maxLoad, currentMovingDirection);
	}
}
