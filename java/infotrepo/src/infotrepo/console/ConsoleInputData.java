
package infotrepo.console;
import java.util.GregorianCalendar;
import java.util.AbstractMap.SimpleEntry;

public class ConsoleInputData {
    public SimpleEntry<Integer, Integer> inputReportNumbers;
    public SimpleEntry<GregorianCalendar, GregorianCalendar> inputDates;
    
    public ConsoleInputData() {
        
    }
    
    public ConsoleInputData(SimpleEntry<Integer, Integer> inputReportNumbers, SimpleEntry<GregorianCalendar, GregorianCalendar> inputDates) {
        this.inputReportNumbers = inputReportNumbers;
        this.inputDates = inputDates;
    }
}
