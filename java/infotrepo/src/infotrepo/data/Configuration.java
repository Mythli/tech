/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.ArrayList;

/**
 *
 * @author Tobias
 */
public class Configuration extends TimeSpan {
    private ConfigurationData data = new ConfigurationData();
    private DateFormat inDateFormat = DateFormat.getDateInstance();
    private DateFormat outDateFormat = DateFormat.getInstance();
    private ArrayList<TrainingBreak> trainingBreakList = new ArrayList<>();
    
    
    public Configuration() throws ParseException {    
    }
    
    public Configuration(ConfigurationData data) throws ParseException {
        this.setData(data);
    }
    
    /**
     * @return the data
     */
    @Override
    public ConfigurationData getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(ConfigurationData data) throws ParseException {
        this.setInDateFormat(new SimpleDateFormat(data.inDateFormat));
        this.setDateFormat(inDateFormat);
        this.setOutDateFormat(new SimpleDateFormat(data.outDateFormat));
        this.setData((SchoolSpanData)data);
        this.setTrainingBreakListData(data.trainingBreakList);   
        
        this.data = data;
    }

    /**
     * @return the inDateFormat
     */
    public DateFormat getInDateFormat() {
        return inDateFormat;
    }

    /**
     * @param inDateFormat the inDateFormat to set
     */
    public void setInDateFormat(DateFormat inDateFormat) {
        this.inDateFormat = inDateFormat;
    }

    /**
     * @return the outDateFormat
     */
    public DateFormat getOutDateFormat() {
        return outDateFormat;
    }

    /**
     * @param outDateFormat the outDateFormat to set
     */
    public void setOutDateFormat(DateFormat outDateFormat) {
        this.outDateFormat = outDateFormat;
    }

    /**
     * @return the trainingBreakList
     */
    public ArrayList<TrainingBreak> getTrainingBreakList() {
        return trainingBreakList;
    }

    /**
     * @param trainingBreakList the trainingBreakList to set
     */
    public void setTrainingBreakList(ArrayList<TrainingBreak> trainingBreakList) {
        this.trainingBreakList = trainingBreakList;
    }
    
    public void setTrainingBreakListData(ArrayList<TrainingBreakData> trainingBreakList) throws ParseException {
        this.trainingBreakList.clear();
        
        for(TrainingBreakData trainingBreakData: trainingBreakList) {
            this.trainingBreakList.add(new TrainingBreak(this.inDateFormat, trainingBreakData));
        }
    }
}
