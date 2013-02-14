/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package infotrepo.data.configuration;

public class SchoolSpanData extends TimeSpanData {
    public SchoolDayData[] schoolDayList;
    
    public SchoolSpanData() {
        this.schoolDayList = new SchoolDayData[7];
    }
    
    public SchoolSpanData(String startDate, String endDate, SchoolDayData[] schoolDayList) {
        super(startDate, endDate);
        this.schoolDayList = schoolDayList;
    }
}
