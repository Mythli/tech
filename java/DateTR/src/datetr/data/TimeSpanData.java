/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datetr.data;
import java.util.GregorianCalendar;
/**
 *
 * @author Tobias
 */
public class TimeSpanData {
    public TimeSpanData() {
        this.startDate = "1.1.2000";
        this.endDate = "1.1.2000";
    }
    
    public TimeSpanData(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public String startDate;
    public String endDate;
}
