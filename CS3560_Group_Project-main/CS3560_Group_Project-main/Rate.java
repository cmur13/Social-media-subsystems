import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;

public class Rate {

    // Class fields.
    public int user_id;
    public int entity_id;
    public String entityType;
    public int rate;
    public LocalDate timeStamp;

    // Class constructor.
    public Rate(int user_id, int entity_id, String entityType, int rate){
        this.user_id = user_id;
        this.entity_id = entity_id;
        this.entityType = entityType;
        this.rate = rate;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    }

    // Class methods.
    public int getAverageRate(int entity_id, String entityType) {
        //get rate from entity_id
        return rate;
    }

}