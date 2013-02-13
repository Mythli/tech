/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data;
import java.util.HashMap;

/**
 *
 * @author Tobias
 */
public class TrainingBreakData extends SchoolSpanData {
    public String description;
    public TrainingBreakType type;
    
    public TrainingBreakData() {
        this.description = "";
        this.type = TrainingBreakType.OTHER;
    }
    
    public TrainingBreakData(String startDate, String endDate, HashMap<Integer, SchoolDayData> schoolDayList, TrainingBreakType type, String description) {
        super(startDate, endDate, schoolDayList);
        this.type = type;
        this.description = description;
    }
}
