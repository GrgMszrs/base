import hu.bme.mit.train.system.TrainSystem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class TrainTachographTest {
    TrainTachograph trainTachograph;
    TrainSystem trainSystem;

    @Before
    public void before() {
        trainTachograph = new TrainTachograph();
        trainSystem = new TrainSystem();
    }

    @Test
    public void Test() {
        trainTachograph.putNewRow(LocalDateTime.now(), trainSystem.getUser().getJoystickPosition(), trainSystem.getController().getReferenceSpeed());
        Assert.assertEquals(1, trainTachograph.getTable().size());
    }
}
