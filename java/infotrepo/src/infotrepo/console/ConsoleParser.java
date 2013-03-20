package infotrepo.console;
import java.io.InputStream;
import java.util.GregorianCalendar;
import infotrepo.data.configuration.TimeSpan;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import infotrepo.data.configuration.Configuration;
import infotrepo.data.configuration.TimeSpanData;
import java.util.AbstractMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.AbstractMap.SimpleEntry;

public class ConsoleParser {
    // 
    private static Pattern spanPattern = Pattern.compile("^(?:von\\s+)?(.+?)\\s+(?:bis\\s+)?(.+?)$");
    private Configuration configuration;
    private InputStream inputStream;
    private BufferedReader buffederedReader;
    
    public ConsoleParser() throws ConsoleParseException {
        try {
            this.configuration = new Configuration();
            this.inputStream = System.in;
            this.buffederedReader = new BufferedReader(new InputStreamReader(this.inputStream));
        } catch(Exception ex) {
            throw new ConsoleParseException("Failed to parse string from input stream!", ex);
        }
    }
    
    public ConsoleParser(Configuration configuration, InputStream inputStream) throws ConsoleParseException {
        try {
            this.setConfiguration(configuration);
            this.setInputStream(inputStream);
            this.buffederedReader = new BufferedReader(new InputStreamReader(this.getInputStream()));
        } catch(Exception ex) {
            throw new ConsoleParseException("Failed to parse string from input stream!", ex);
        }
    }
    
    public String readString() throws ConsoleParseException { 
        try {
            return this.buffederedReader.readLine();
        } catch(Exception ex) {
            throw new ConsoleParseException("Failed to parse string from input stream!", ex);
        }
    }
    
    public int parseInteger(String integerString) throws ConsoleParseException {
        try {
            return Integer.parseInt(integerString);
        } catch(Exception ex) {
            throw new ConsoleParseException("Failed to parse integer from input stream!", ex);
        }
    }
    
    public GregorianCalendar parseDate(String dateString) throws ConsoleParseException {
        try {
            GregorianCalendar date = new GregorianCalendar();
            date.setTime(this.configuration.getInDateFormat().parse(dateString));
            return date;
        } catch(Exception ex) {
            throw new ConsoleParseException("Failed to parse date from input stream!", ex);
        }
    }
    
    public SimpleEntry<String, String> parseSpan(String spanString) throws ConsoleParseException {
        Matcher spanMatcher = ConsoleParser.spanPattern.matcher(spanString);
        if(spanMatcher.matches()) {
            for(int i = 0; i < spanMatcher.groupCount() + 1; i++) {
                System.out.println(i + " " + spanMatcher.group(i));
            }
            SimpleEntry spanPair = new SimpleEntry(spanMatcher.group(1), spanMatcher.group(2));
            return spanPair;
        } 
        
        throw new ConsoleParseException("Failed to parse span! pattern: "+ConsoleParser.spanPattern.pattern());
    }
    
    public  SimpleEntry<GregorianCalendar, GregorianCalendar> parseTimeSpan(String timeSpanString) throws ConsoleParseException {
        try {
            SimpleEntry<String, String> spanPair = this.parseSpan(timeSpanString);
            GregorianCalendar fromDate = new GregorianCalendar();
            fromDate.setTime(this.getConfiguration().getInDateFormat().parse(spanPair.getKey()));
            GregorianCalendar toDate = new GregorianCalendar();
            toDate.setTime(this.getConfiguration().getInDateFormat().parse(spanPair.getValue()));
            return new SimpleEntry<GregorianCalendar, GregorianCalendar>(fromDate, toDate);
        } catch(Exception ex) {
            throw new ConsoleParseException("Failed to parse time span from input stream!", ex);
        }
    }
    
    public ConsoleInput parseInput(String inputString) {
        ConsoleInputData data = new ConsoleInputData();
        
        try {
            data.inputReportNumbers = new AbstractMap.SimpleEntry<Integer, Integer>(this.parseInteger(inputString), 0);
            data.consoleInputMode = ConsoleInputMode.REPORT_NR;
            return new ConsoleInput(data);
        } catch(Exception ex) { }
        
        try {
            data.inputReportNumbers = this.parseNumberSpan(inputString);
            data.consoleInputMode = ConsoleInputMode.REPORT_NR_REPORT_NR;
            return new ConsoleInput(data);
        } catch(Exception ex) { }
               
        try {
            data.inputDates = this.parseTimeSpan(inputString);
            data.consoleInputMode = ConsoleInputMode.DATE_DATE;
            return new ConsoleInput(data);
        } catch(Exception ex) { }
        
        try {
            data.inputDates = new AbstractMap.SimpleEntry<GregorianCalendar, GregorianCalendar>(this.parseDate(inputString), null);
            data.consoleInputMode = ConsoleInputMode.DATE;
            return new ConsoleInput(data);
        } catch(Exception ex) { }
        
        
        throw new ConsoleParseException("Failed to parse input or input is invalid.");
    }
    
    public SimpleEntry<Integer, Integer> parseNumberSpan(String spanString) throws ConsoleParseException {
        SimpleEntry<String, String> spanPair = parseSpan(spanString);
        
        return new SimpleEntry<Integer, Integer>(Integer.parseInt(spanPair.getKey()), Integer.parseInt(spanPair.getValue()));
    }
    
    public boolean parseQuit(String quitString) {
        return quitString.startsWith("q");
    }

    /**
     * @return the inputStream
     */
    public InputStream getInputStream() {
        return inputStream;
    }

    /**
     * @param inputStream the inputStream to set
     */
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * @return the configuration
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * @param configuration the configuration to set
     */
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
