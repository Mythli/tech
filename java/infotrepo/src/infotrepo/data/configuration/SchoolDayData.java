/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data.configuration;
import java.util.ArrayList;
import java.util.GregorianCalendar;
/**
 *
 * @author Tobias
 */
public class SchoolDayData {
    public boolean isSchoolDay = false;
    public int dayNr = GregorianCalendar.MONDAY;
    public ArrayList<String> lessonSubjectList = new ArrayList<>();
    
    public SchoolDayData() {
        
    }
    
    public SchoolDayData(boolean isSchoolDay, int dayNr, ArrayList<String> subjectList) {
        this.isSchoolDay = isSchoolDay;
        this.dayNr = dayNr;
        this.lessonSubjectList = subjectList;
    }
}
