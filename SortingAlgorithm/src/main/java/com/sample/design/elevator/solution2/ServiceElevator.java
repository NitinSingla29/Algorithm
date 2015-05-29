package com.sample.design.elevator.solution2;

import java.util.PriorityQueue;

import com.sample.design.elevator.solution2.states.ElevatorState;

public class ServiceElevator extends Elevator {

	public ServiceElevator(ElevatorState currentElevatorState, int maxFloors, int currentFloor, PriorityQueue<Pessanger> personsMovingUp,
			PriorityQueue<Pessanger> personsMovingDown, int currentLoad, int maxLoad, MovingDirection currentMovingDirection) {
		super(currentElevatorState, maxFloors, currentFloor, personsMovingUp, personsMovingDown, currentLoad, maxLoad, currentMovingDirection);
	}
}
