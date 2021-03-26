package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private final TrainController controller;
	private final TrainUser user;
	private int speedLimit = 5;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		boolean alarmState = false;
		if(speedLimit < 0 || speedLimit > 500){
			alarmState = true;
		}

		if(speedLimit < controller.getReferenceSpeed() / 2){
			alarmState = true;
		}
		int a = getSpeedLimit();
		user.setAlarmState(alarmState);

		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}
}
