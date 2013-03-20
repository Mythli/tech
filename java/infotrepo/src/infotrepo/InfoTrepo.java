/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo;

import infotrepo.data.configuration.JsonConfigurationProvider;
import infotrepo.data.configuration.Configuration;
import infotrepo.data.configuration.AbstractConfigurationProvider;
import infotrepo.data.*;
import com.google.gson.*;
import infotrepo.holiday.HolidayEventCalculator;
import infotrepo.holiday.HolidayEventData;
import java.util.GregorianCalendar;
import infotrepo.console.*;
import infotrepo.data.configuration.TestConfigurationProvider;

/**
 *
 * @author tobias
 */
public class InfoTrepo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        AbstractConfigurationProvider configurationProvider = new TestConfigurationProvider();
        ConsoleHandler consoleHandler;
        Configuration configuration;
        InputProcessor inputProcessor;
        try {
            configuration = configurationProvider.getConfiguration();
            consoleHandler = new ConsoleHandler(configuration, System.in, System.out);
            inputProcessor = new InputProcessor(configuration);
            
            consoleHandler.getPrinter().printHelloMessage();
            boolean continueExecution = true;
            while(continueExecution) {
                consoleHandler.getPrinter().printInpuDataInfoMessage();
                String consoleInput = consoleHandler.getParser().readString();
                if(consoleHandler.getParser().parseQuit(consoleInput) != true) {
                    try {
                        ConsoleInput input = consoleHandler.getParser().parseInput(consoleInput);
                        input = inputProcessor.processInput(input);
                        int a = 5;
                    } catch(ConsoleParseException ex) {
                        consoleHandler.getPrinter().printInputMissmatch();
                    }
                } else {
                    continueExecution = false;
                }
            }
            consoleHandler.getPrinter().printGoodbyeMessage();
            
        } catch(Exception ex) {
            System.out.println("Das tut uns leid. Leider ist ein unbekannter Fehler aufgetreten. " + ex.getMessage());
            System.exit(1);
        }
        
        
        
         //configurationProvider.saveConfiguration();
        
        
        /*HolidayEventCalculator calculator = new HolidayEventCalculator();
        GregorianCalendar reference = new GregorianCalendar();
        reference.set(GregorianCalendar.YEAR, 2000);
        HolidayEventData data = calculator.checkFirstChristmasDay(reference);
        
        boolean check = configuration.isWithinTimeSpan(data.day);
        
        
        System.out.println(configuration.getOutDateFormat().format(data.day.getTime()));*/
    }
}
