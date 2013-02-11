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
        this.startDate = "";
        this.endDate = "";
    }
    
    public TimeSpanData(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public String startDate = "";
    public String endDate = "";
}
