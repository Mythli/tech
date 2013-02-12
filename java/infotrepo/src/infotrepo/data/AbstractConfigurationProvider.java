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
    private boolean autoSave = false;
    
    public abstract ConfigurationData getConfigurationData() throws ConfigurationProviderIOException;
    public Configuration getConfiguration() throws ConfigurationProviderIOException {
        try {
            return new Configuration(this.getConfigurationData());
        } catch (ParseException ex) {
            throw new ConfigurationProviderIOException("Failed to parse configuration!", ex);
        }
    }
    
     public void close() {
        if(this.autoSave) {
            this.saveConfiguration();
        }
    }
    
    public abstract void saveConfiguration() throws ConfigurationProviderIOException; 

    /**
     * @return the autoSave
     */
    public boolean isAutoSave() {
        return autoSave;
    }

    /**
     * @param autoSave the autoSave to set
     */
    public void setAutoSave(boolean autoSave) {
        this.autoSave = autoSave;
    }
}
