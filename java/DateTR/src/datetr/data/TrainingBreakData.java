/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datetr.data;
import java.util.GregorianCalendar;

/**
 *
 * @author Tobias
 */
public class TrainingBreakData extends TimeSpanData {
    public String description;
    public TrainingBreakType type;
    
    public TrainingBreakData() {
        
    }
    
    public TrainingBreakData(TrainingBreakType type, String description, String startDate, String endDate) {
        super(startDate, endDate);
        this.type = type;
        this.description = description;
    }
}
