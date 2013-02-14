/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data.configuration;
import java.util.GregorianCalendar;
/**
 *
 * @author Tobias
 */
public class TimeSpanData {
    public String startDate = "1.1.1000";
    public String endDate = "1.1.1000";
    
    public TimeSpanData() {
    }
    
    public TimeSpanData(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
