/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datetr.data;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author tobias
 */
public class TestConfigurationProvider extends AbstractConfigurationProvider {
    public @Override ConfigurationData getConfigurationData() throws ParseException {
        ConfigurationData configurationData = new ConfigurationData();
        
        configurationData.inDateFormat = "dd.mm.yyy";
        configurationData.outDateFormat = configurationData.inDateFormat;
               
        configurationData.startDate = "6.11.2012";
        configurationData.endDate = "31.7.2014";
        configurationData.schoolDays = new boolean[7];
        
        configurationData.trainingBreakList = new ArrayList<TrainingBreakData>();
        TrainingBreakData tbData = new TrainingBreakData();
        tbData.type = TrainingBreakType.ILL;
        tbData.description = "Bronchitis";
        tbData.startDate = "7.2.2013";
        tbData.endDate = "8.2.2013";
        configurationData.trainingBreakList.add(tbData);
        
        return  configurationData;
    }
}
