/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package infotrepo.data;

import java.util.ArrayList;

public class SchoolSpanData extends TimeSpanData {
    public ArrayList<SchoolDayData> schoolDayList = new ArrayList<>();
    
    public SchoolSpanData() {
        
    }
    
    public SchoolSpanData(String startDate, String endDate, ArrayList<SchoolDayData> schoolDayList) {
        super(startDate, endDate);
        this.schoolDayList = schoolDayList;
    }
}
