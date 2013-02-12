package infotrepo.holiday;
import java.util.GregorianCalendar;
import infotrepo.util.StateType;

public class HolidayEventData {
    public HolidayEventType type = HolidayEventType.ORDINARY_DAY;
    public boolean isTrue = false;
    public int validity = StateType.ALL;
    public boolean isHoliday = false;
    public boolean isWorkDay = true;
    public String name = "Work Day";
    public GregorianCalendar day = new GregorianCalendar();
    
    public HolidayEventData() {
        
    }
    
    public HolidayEventData(HolidayEventType type, int validity, boolean isWorkDay, boolean isHoliday, String name, GregorianCalendar day) {
        this.type = type;
        this.validity = validity;
        this.isHoliday = isHoliday;
        this.isWorkDay = isWorkDay;
        this.name = name;
        this.day = day;
    }  
}
