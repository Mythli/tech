/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data.configuration;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
/**
 *
 * @author Tobias
 */
public class TimeSpan {
    private DateFormat dateFormat;
    private TimeSpanData data;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    
    public TimeSpan() throws ParseException {
        this.setDateFormat(DateFormat.getDateInstance());
        this.setData(new TimeSpanData());
    }
    
    public TimeSpan(DateFormat dateFormat, TimeSpanData data) throws ParseException {
        this.setDateFormat(dateFormat);
        this.setData(data);
    }
    
    public TimeSpan(GregorianCalendar startDate, GregorianCalendar endDate) {
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }
    
    public boolean isWithinTimeSpan(GregorianCalendar compareTo) {
        int startDateCompareResult = this.getStartDate().compareTo(compareTo);
        int endDateCompareresult = this.getEndDate().compareTo(compareTo);
        if(startDateCompareResult <= 0 && endDateCompareresult >= 0) {
            return true;
        }
        return false;
    }

    /**
     * @return the data
     */
    public TimeSpanData getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(TimeSpanData data) throws ParseException {
        GregorianCalendar startDate = new GregorianCalendar();
        startDate.setTime(this.dateFormat.parse(data.startDate));
        this.setStartDate(startDate);
        
        GregorianCalendar endDate = new GregorianCalendar();
        endDate.setTime(this.dateFormat.parse(data.endDate));
        this.setEndDate(endDate);
        this.data = data;
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
     * @return the dateFormat
     */
    public DateFormat getDateFormat() {
        return dateFormat;
    }

    /**
     * @param dateFormat the dateFormat to set
     */
    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }
    
    
}
