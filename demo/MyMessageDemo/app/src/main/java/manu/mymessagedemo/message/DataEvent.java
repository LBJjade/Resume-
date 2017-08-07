package manu.mymessagedemo.message;

/**
 * Created by weedys on 16/7/26.
 */
public class DataEvent {
    public final static int TYPE_NUMTV=0X01;//设置文本数量

    public int eventId = 0;
    public String value ="";
    public DataEvent(int eId, String val){
        this.eventId = eId;
        this.value = val;
    }
    public DataEvent(int eId){
        this.eventId = eId;
        this.value = "1";
    }
}
