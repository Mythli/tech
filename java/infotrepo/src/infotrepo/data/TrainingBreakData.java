/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data;
import java.util.ArrayList;

/**
 *
 * @author Tobias
 */
public class TrainingBreakData extends TimeSpanData {
    public String description = "";
    public TrainingBreakType type = TrainingBreakType.OTHER;
    public ArrayList<SchoolDayData> schoolDayList = new ArrayList<>();
    
    public TrainingBreakData() {
        
    }
    
    public TrainingBreakData(TrainingBreakType type, String description, String startDate, String endDate) {
        super(startDate, endDate);
        this.type = type;
        this.description = description;
    }
}
