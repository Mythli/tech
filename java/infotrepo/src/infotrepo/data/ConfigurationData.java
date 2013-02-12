/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tobias
 */
public class ConfigurationData extends TimeSpanData {
    public ArrayList<SchoolDayData> schoolDayList = new ArrayList<>();
    public ArrayList<TrainingBreakData> trainingBreakList = new ArrayList<>();
    
    public String inDateFormat = "dd-mm-yyy";
    public String outDateFormat = "dd-mm-yyy";
}
