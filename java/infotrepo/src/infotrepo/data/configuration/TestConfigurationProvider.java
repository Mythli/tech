/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data.configuration;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author tobias
 */
public class TestConfigurationProvider extends AbstractConfigurationProvider {
    public @Override ConfigurationData getConfigurationData() throws ConfigurationProviderIOException {
        ConfigurationData configurationData = new ConfigurationData();
        
        configurationData.inDateFormat = "dd.MM.yyy";
        configurationData.outDateFormat = configurationData.inDateFormat;

        configurationData.startDate = "6.11.2012";
        configurationData.endDate = "31.7.2014";
        configurationData.trainingBreakList = new ArrayList<TrainingBreakData>();
        
        configurationData.trainingBreakList.add(new TrainingBreakData("7.2.2013", "8.2.2013", null, TrainingBreakType.ILL, "Bronchitis"));
       
        TrainingBreakData school = new TrainingBreakData("1.1.2013", "1.2.2013", new SchoolDayData[7], TrainingBreakType.ILL, "Berufsschule");
        ArrayList<String> schoolLessons = new ArrayList<>();
        schoolLessons.add("ITN");
        schoolLessons.add("ITN");
        schoolLessons.add("AWE");
        schoolLessons.add("AWE");
        schoolLessons.add("AWE");
        schoolLessons.add("RELI");
        schoolLessons.add("WGP");
        SchoolDayData schoolDayData = new SchoolDayData(true, GregorianCalendar.MONDAY, schoolLessons);
        school.schoolDayList[schoolDayData.dayNr] = schoolDayData;
        configurationData.trainingBreakList.add(school);
        
        return  configurationData;
    }

    @Override
    public void saveConfiguration() throws ConfigurationProviderIOException {
    }
}
