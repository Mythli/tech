/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datetr.configuration;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author tobias
 */
public class ConfigurationDataProviderTest extends ConfigurationProviderAbstract {
    public @Override ConfigurationData getConfigurationData() throws ParseException {
        ConfigurationData returnConfigurationData = new ConfigurationData();
        
        returnConfigurationData.parseDateFormat = "yyy-mm-dd";
        returnConfigurationData.printDateFormat = returnConfigurationData.parseDateFormat;
        
        //2012-06-11-2012
        SimpleDateFormat formatter = new SimpleDateFormat(returnConfigurationData.parseDateFormat);
        
        
        returnConfigurationData.startDate.setTime(formatter.parse("2012-6-11"));
        returnConfigurationData.endDate = new GregorianCalendar();
        
        returnConfigurationData.schoolDays = new ArrayList<Integer>();
        
        
        return  returnConfigurationData;
    }
}
