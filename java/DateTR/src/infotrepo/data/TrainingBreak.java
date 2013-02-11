/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data;
import java.text.ParseException;
import java.util.GregorianCalendar;
import java.text.DateFormat;
/**
 *
 * @author Tobias
 */
public class TrainingBreak extends TimeSpan {
    private TrainingBreakData data = new TrainingBreakData();
   
    public TrainingBreak() throws ParseException {
    }
    
    public TrainingBreak(DateFormat format, TrainingBreakData data) throws ParseException {
        this.setDateFormat(format);
        this.setData(data);
    }
    
    public TrainingBreak(TrainingBreakType type, String description, DateFormat format, GregorianCalendar startDate, GregorianCalendar endDate) throws ParseException {
        this.setData(new TrainingBreakData());
        this.data.type = type;
        this.data.description = description;
        this.setDateFormat(format);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }
    
    /**
     * @return the data
     */
    @Override
    public TrainingBreakData getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(TrainingBreakData data) throws ParseException {
        this.setData((TimeSpanData)data);
        this.data = data;
    }
}
