/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;

public class SchoolSpan extends TimeSpan {
    private SchoolSpanData data = new SchoolSpanData();
        
    public SchoolSpan() throws ParseException {
    }
    public SchoolSpan(DateFormat dateFormat, SchoolSpanData data) throws ParseException {
        this.setDateFormat(dateFormat);
        this.setData(data);
    }
    
    public boolean hasSchoolDays() {
        return this.getData().schoolDayList.size() > 0;
    }

    /**
     * @return the data
     */
    @Override
    public SchoolSpanData getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(SchoolSpanData data) throws ParseException {
        this.setData((TimeSpanData)data);
        this.data = data;
    }
}
