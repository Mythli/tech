/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data;

import java.text.ParseException;

/**
 *
 * @author tobias
 */
public abstract class AbstractConfigurationProvider {
    public abstract ConfigurationData getConfigurationData() throws ConfigurationProviderIOException;
    public Configuration getConfiguration() throws ConfigurationProviderIOException {
        try {
            return new Configuration(this.getConfigurationData());
        } catch (ParseException ex) {
            throw new ConfigurationProviderIOException("Failed to parse configuration!", ex);
        }
    }
    
    public abstract void saveConfiguration() throws ConfigurationProviderIOException;
}
