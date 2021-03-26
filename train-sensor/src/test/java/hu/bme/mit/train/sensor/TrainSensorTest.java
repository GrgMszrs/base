package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
    TrainSensorImpl sensor;
    TrainUser user;
    TrainController controller;

    @Before
    public void before() {
        user = mock(TrainUser.class);
        controller = mock(TrainController.class);
        sensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void testLargeSpeedLimit() {
        sensor.overrideSpeedLimit(678);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void testNegativeSpeedLimit() {
        sensor.overrideSpeedLimit(-12);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void testNormalSpeedLimit() {
        sensor.overrideSpeedLimit(7);
        verify(user, times(1)).setAlarmState(false);
    }

    @Test
    public void testNegativeSpeedLimitFalse() {
        sensor.overrideSpeedLimit(-2);
        verify(user, times(0)).setAlarmState(false);
    }
}
