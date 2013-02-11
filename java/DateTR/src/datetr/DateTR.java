/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datetr;

import datetr.data.*;

/**
 *
 * @author tobias
 */
public class DateTR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AbstractConfigurationProvider configurationProvider = new TestConfigurationProvider();
        Configuration configuration = null;
        try {
            configuration = configurationProvider.getConfiguration();
        } catch(Exception ex) {
            System.out.println("Das tut uns leid. Leider konnte die Konfiguration nicht geladen werden. " + ex.getMessage());
            System.exit(1);
        }
        
        try { 
            TrainingBreakData data = new TrainingBreakData();
            //TrainingBreak trainingBreak = new TrainingBreak(data);
            int a = 5;
        } catch (Exception ex)
        {
            
        }
    }
}
