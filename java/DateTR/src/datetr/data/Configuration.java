/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datetr.data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.ArrayList;

/**
 *
 * @author Tobias
 */
public class Configuration {
    private ConfigurationData data;
    private DateFormat inDateFormat;
    private DateFormat outDateFormat;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private ArrayList<TrainingBreak> trainingBreakList;
    
    public Configuration() {
    }
    
    public Configuration(ConfigurationData data) throws ParseException {
        this.setData(data);
    }
    
    /**
     * @return the startDate
     */
    public GregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public GregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the data
     */
    public ConfigurationData getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(ConfigurationData data) throws ParseException {
        this.setInDateFormat(new SimpleDateFormat(data.inDateFormat));
        GregorianCalendar startDate = new GregorianCalendar();
        startDate.setTime(this.getInDateFormat().parse(data.startDate));
        this.setStartDate(startDate);
        this.setOutDateFormat(new SimpleDateFormat(data.outDateFormat));
        GregorianCalendar endDate = new GregorianCalendar();
        endDate.setTime(this.getInDateFormat().parse(data.endDate));
        this.setEndDate(endDate);      
        
        //this.setTrainingBreakListData(data.trainingBreakList);
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
        for(TrainingBreakData trainingBreakData: trainingBreakList) {
            GregorianCalendar trainingBreakStartDate = new GregorianCalendar();
            trainingBreakStartDate.setTime(this.getInDateFormat().parse(trainingBreakData.startDate));
            GregorianCalendar trainingBreakEndDate = new GregorianCalendar();
            trainingBreakEndDate.setTime(this.getInDateFormat().parse(trainingBreakData.endDate));
            
            //this.getTrainingBreakList().add(new TrainingBreak(trainingBreakData, trainingBreakStartDate, trainingBreakEndDate));
        }
    }
}
