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
            SimpleEntry spanPair = new SimpleEntry(spanMatcher.group(1), spanMatcher.group(2));
            return spanPair;
        } 
        
        throw new ConsoleParseException("Failed to parse span! pattern: "+ConsoleParser.spanPattern.pattern());
    }
    
    public TimeSpan parseTimeSpan(String timeSpanString) throws ConsoleParseException {
        try {
            SimpleEntry<String, String> timeSpanPair = this.parseSpan(timeSpanString);
            TimeSpanData timeSpanData = new TimeSpanData(timeSpanPair.getKey(), timeSpanPair.getValue());
            TimeSpan timeSpan = new TimeSpan(this.configuration.getInDateFormat(), timeSpanData);

            return timeSpan;
        } catch(Exception ex) {
            throw new ConsoleParseException("Failed to parse time span from input stream!", ex);
        }
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
