package infotrepo.console;
import java.io.InputStream;
import java.io.PrintStream;
import infotrepo.data.configuration.Configuration;
import java.text.ParseException;

public class ConsoleHandler {
    private Configuration configuration = new Configuration();
    private ConsoleParser parser = new ConsoleParser();
    private ConsolePrinter printer = new ConsolePrinter();
    
    public ConsoleHandler() throws ParseException {
        
    }
    
    public ConsoleHandler(Configuration configuration, InputStream inputStream, PrintStream outputStream) throws ParseException {
        this.parser = new ConsoleParser(configuration, inputStream);
        this.printer = new ConsolePrinter(outputStream);
        this.setConfiguration(configuration);
    }
    public boolean processInpput(String input) {
        boolean continueInput = true;
        
        return continueInput;
    }
    /**
     * @return the consoleParser
     */
    public ConsoleParser getParser() {
        return parser;
    }

    /**
     * @param consoleParser the consoleParser to set
     */
    public void setParser(ConsoleParser consoleParser) {
        this.parser = consoleParser;
    }

    /**
     * @return the consolePrinter
     */
    public ConsolePrinter getPrinter() {
        return printer;
    }

    /**
     * @param consolePrinter the consolePrinter to set
     */
    public void setPrinter(ConsolePrinter consolePrinter) {
        this.printer = consolePrinter;
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
        this.parser.setConfiguration(this.getConfiguration());
    }
}
