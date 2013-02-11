/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datetr.data;

import java.text.ParseException;

/**
 *
 * @author tobias
 */
public abstract class AbstractConfigurationProvider {
    public abstract ConfigurationData getConfigurationData() throws ParseException;
    public Configuration getConfiguration() throws ParseException {
        return new Configuration(this.getConfigurationData());
    }
}
