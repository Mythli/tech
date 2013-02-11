/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datetr.data;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tobias
 */
public class ConfigurationData {
    public String startDate;
    public String endDate;
    
    public boolean[] schoolDays;
    public ArrayList<TrainingBreakData> trainingBreakList;
    
    public String inDateFormat;
    public String outDateFormat;
}
