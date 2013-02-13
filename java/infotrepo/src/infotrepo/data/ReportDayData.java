package infotrepo.data;
import infotrepo.holiday.HolidayEventData;
import java.util.GregorianCalendar;

public class ReportDayData {
    public GregorianCalendar day = null;
    public HolidayEventData  holidayEventData = null;
    public TrainingBreak trainingBreak = null;
    public SchoolSpan schoolSpan = null;
    
    public ReportDayData() {
        this.day = new GregorianCalendar();
    }
    
    public ReportDayData(GregorianCalendar day, HolidayEventData holidayEventData, TrainingBreak trainingBreak, SchoolSpan schoolSpan) {
        this.day = day;
        this.holidayEventData = holidayEventData;
        this.trainingBreak = trainingBreak;
        this.schoolSpan = schoolSpan;
    }
}
