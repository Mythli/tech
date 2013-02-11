/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo;

import infotrepo.data.*;
import com.google.gson.*;

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
        Configuration configuration = null;
        try {
            configuration = configurationProvider.getConfiguration();
            configurationProvider.saveConfiguration();
        } catch(Exception ex) {
            System.out.println("Das tut uns leid. Leider konnte die Konfiguration nicht geladen werden. " + ex.getMessage());
            System.exit(1);
        }
        
        Gson jsonSerializer = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(jsonSerializer.toJson(configuration.getData()));
    }
}
