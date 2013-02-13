/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package infotrepo.data;

import java.util.HashMap;

public class SchoolSpanData extends TimeSpanData {
    public HashMap<Integer, SchoolDayData> schoolDayList = new HashMap<Integer, SchoolDayData>();
    
    public SchoolSpanData() {
        
    }
    
    public SchoolSpanData(String startDate, String endDate, HashMap<Integer, SchoolDayData> schoolDayList) {
        super(startDate, endDate);
        this.schoolDayList = schoolDayList;
    }
}
