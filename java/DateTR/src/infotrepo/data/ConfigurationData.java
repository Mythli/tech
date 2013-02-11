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
    public boolean[] schoolDays;
    public ArrayList<TrainingBreakData> trainingBreakList;
    
    public String inDateFormat;
    public String outDateFormat;
}
