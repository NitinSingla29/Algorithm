package com.sample.design.elevator;

public abstract class ElevatorState implements IState {

	private final Elevator elevator;

	public ElevatorState(Elevator elevator) {
		super();
		this.elevator = elevator;
	}

	public Elevator getElevator() {
		return elevator;
	}

	public static class BeepOffState extends ElevatorState {

		public BeepOffState(Elevator elevator) {
			super(elevator);
		}

		@Override
		public void doAcion() {
			// Move elevator in up direction
		}
	}

	public static class BeepOnState extends ElevatorState {

		public BeepOnState(Elevator elevator) {
			super(elevator);
		}

		@Override
		public void doAcion() {
			// Move elevator in up direction
		}
	}

	public static class LoadingState extends ElevatorState {

		public LoadingState(Elevator elevator) {
			super(elevator);
		}

		@Override
		public void doAcion() {
			// Move elevator in up direction
		}
	}

	public static class MovingDownState extends ElevatorState {

		public MovingDownState(Elevator elevator) {
			super(elevator);
		}

		@Override
		public void doAcion() {
			// Move elevator in up direction
		}
	}

	public static class MovingUpState extends ElevatorState {

		public MovingUpState(Elevator elevator) {
			super(elevator);
		}

		@Override
		public void doAcion() {
			// Move elevator in up direction
		}
	}

	public static class UnloadingState extends ElevatorState {

		public UnloadingState(Elevator elevator) {
			super(elevator);
		}

		@Override
		public void doAcion() {
			// Move elevator in up direction
		}
	}

}
