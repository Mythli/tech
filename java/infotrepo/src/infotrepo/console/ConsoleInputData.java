
package infotrepo.console;
import java.util.GregorianCalendar;
import java.util.AbstractMap.SimpleEntry;

public class ConsoleInputData {
    public ConsoleInputMode consoleInputMode;
    public Object data;
    public SimpleEntry<Integer, Integer> inputReportNumbers;
    public SimpleEntry<GregorianCalendar, GregorianCalendar> inputDates;
    
    public ConsoleInputData() {
        
    }
    
    public ConsoleInputData(ConsoleInputMode consoleInputMode, SimpleEntry<Integer, Integer> inputReportNumbers, SimpleEntry<GregorianCalendar, GregorianCalendar> inputDates) {
        this.consoleInputMode = consoleInputMode;
        this.inputReportNumbers = inputReportNumbers;
        this.inputDates = inputDates;
    }
}
