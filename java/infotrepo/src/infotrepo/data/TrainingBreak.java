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
public class TrainingBreak extends SchoolSpan {
    private TrainingBreakData data = new TrainingBreakData();
   
    public TrainingBreak() throws ParseException {
    }
    
    public TrainingBreak(DateFormat dateFormat, TrainingBreakData data) throws ParseException {
        this.setDateFormat(dateFormat);
        this.setData(data);
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
        this.setData((SchoolSpanData)data);
        this.data = data;
    }
}
