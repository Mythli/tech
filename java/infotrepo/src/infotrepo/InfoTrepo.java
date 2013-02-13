/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo;

import infotrepo.data.*;
import com.google.gson.*;
import infotrepo.holiday.HolidayEventCalculator;
import infotrepo.holiday.HolidayEventData;
import java.util.GregorianCalendar;
import java.text.DateFormat;

/**
 *
 * @author tobias
 */
public class InfoTrepo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        AbstractConfigurationProvider configurationProvider = new JsonConfigurationProvider();
        Configuration configuration = null;
        try {
            configuration = configurationProvider.getConfiguration();
        } catch(Exception ex) {
            System.out.println("Das tut uns leid. Leider konnte die Konfiguration nicht geladen werden. " + ex.getMessage());
            System.exit(1);
        }
        
         //configurationProvider.saveConfiguration();
        Gson jsonSerializer = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(jsonSerializer.toJson(configuration.getData()));
        
        HolidayEventCalculator calculator = new HolidayEventCalculator();
        GregorianCalendar reference = new GregorianCalendar();
        reference.set(GregorianCalendar.YEAR, 2014);
        HolidayEventData data = calculator.checkGoodFriday(reference);
        System.out.println(configuration.getOutDateFormat().format(data.day.getTime()));
    }
}
