package com.sample.design.multilevelparking;

public interface ParkingSizeFindingStrategy {

	ParkingSize getRequiredParkingSize(Vehicle vehicle);

}
