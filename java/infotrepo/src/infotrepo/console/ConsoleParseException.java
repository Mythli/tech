/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.console;
import java.lang.Throwable;

/**
 *
 * @author Tobias
 */
public class ConsoleParseException extends RuntimeException {
    public ConsoleParseException() {
        super();
    }
    
    public ConsoleParseException(String message) {
        super(message);
    }
    
    public ConsoleParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
