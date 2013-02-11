/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author tobias
 */
public class TestConfigurationProvider extends AbstractConfigurationProvider {
    public @Override ConfigurationData getConfigurationData() throws ConfigurationProviderIOException {
        ConfigurationData configurationData = new ConfigurationData();
        
        configurationData.inDateFormat = "dd.mm.yyy";
        configurationData.outDateFormat = configurationData.inDateFormat;

        configurationData.startDate = "6.11.2012";
        configurationData.endDate = "31.7.2014";
        
        configurationData.isBlockInstruction = true;
        
        configurationData.trainingBreakList = new ArrayList<TrainingBreakData>();
        
        configurationData.trainingBreakList.add(new TrainingBreakData(TrainingBreakType.ILL, "Bronchitis", "7.2.2013", "8.2.2013"));
        
        TrainingBreakData school = new TrainingBreakData(TrainingBreakType.ILL, "Berufsschule", "1.1.2013", "1.2.2013");
        school.hasSchoolDays = true;
        ArrayList<String> schoolLessons = new ArrayList<>();
        schoolLessons.add("ITN");
        schoolLessons.add("ITN");
        schoolLessons.add("AWE");
        schoolLessons.add("AWE");
        schoolLessons.add("AWE");
        schoolLessons.add("RELI");
        schoolLessons.add("WGP");
        SchoolDayData schoolDayData = new SchoolDayData(true, GregorianCalendar.MONDAY, schoolLessons);
        school.schoolDayList.add(schoolDayData);
        configurationData.trainingBreakList.add(school);
        
        return  configurationData;
    }

    @Override
    public void saveConfiguration() throws ConfigurationProviderIOException {
    }
}
