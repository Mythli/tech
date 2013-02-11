/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datetr.data;
import java.text.ParseException;
import java.util.GregorianCalendar;
/**
 *
 * @author Tobias
 */
public class TrainingBreak extends TimeSpan {
    private TrainingBreakData data;
   
    public TrainingBreak() throws ParseException {
        this.setData(new TrainingBreakData());
    }
    
    public TrainingBreak(TrainingBreakData data) throws ParseException {
        this.setData(data);
    }
    
    public TrainingBreak(TrainingBreakType type, String description, GregorianCalendar startDate, GregorianCalendar endDate) throws ParseException {
        this.setData(new TrainingBreakData());
        this.data.type = type;
        this.data.description = description;
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
        this.setData(new TimeSpanData(data.startDate, data.endDate));
        this.data = data;
    }
}
