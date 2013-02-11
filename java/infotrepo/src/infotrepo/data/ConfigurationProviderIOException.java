/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data;
import java.lang.Throwable;

/**
 *
 * @author Tobias
 */
public class ConfigurationProviderIOException extends RuntimeException {
    public ConfigurationProviderIOException() {
        super();
    }
    
    public ConfigurationProviderIOException(String message) {
        super(message);
    }
    
    public ConfigurationProviderIOException(String message, Throwable cause) {
        super(message, cause);
    }
}
