import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

import java.time.LocalDateTime;

public class TrainTachograph {
   private Table<LocalDateTime, Integer, Integer> tachographTable;

    public TrainTachograph(){
        tachographTable = TreeBasedTable.create();
    }

    public void putNewRow(LocalDateTime currTime, int joyPoz, int refSpeed){
        tachographTable.put(currTime, joyPoz, refSpeed);
    }

    public Table<LocalDateTime, Integer, Integer> getTable(){
        return tachographTable;
    }
}
