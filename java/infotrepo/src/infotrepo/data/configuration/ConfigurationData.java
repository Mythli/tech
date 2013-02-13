/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data.configuration;
import infotrepo.data.SchoolSpanData;
import infotrepo.data.TrainingBreakData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tobias
 */
public class ConfigurationData extends SchoolSpanData {
    public ArrayList<TrainingBreakData> trainingBreakList = new ArrayList<TrainingBreakData>();
    
    public String inDateFormat = "dd-mm-yyy";
    public String outDateFormat = "dd-mm-yyy";
    
    public ConfigurationData() {
        
    }
}
