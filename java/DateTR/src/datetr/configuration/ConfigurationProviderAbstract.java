/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datetr.configuration;

import java.text.ParseException;

/**
 *
 * @author tobias
 */
public abstract class ConfigurationProviderAbstract {
    public abstract ConfigurationData getConfigurationData() throws ParseException;
    
}
