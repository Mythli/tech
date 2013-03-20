package infotrepo;
import infotrepo.console.ConsoleInput;
import infotrepo.data.configuration.Configuration;
import infotrepo.data.configuration.TimeSpan;
import java.text.ParseException;
import java.util.AbstractMap;
import java.util.Calendar;
import java.util.GregorianCalendar;

public  class InputProcessor {
    private Configuration configuration;
    
    public InputProcessor() throws ParseException {
        this.setConfiguration(new Configuration());
    }
    
    public InputProcessor(Configuration configuration) {
        this.setConfiguration(configuration);
    }
    
    public int getReportNrByDate(GregorianCalendar day) throws Exception {
        int reportNr = 0;
        
        GregorianCalendar tmpDate = (GregorianCalendar)this.configuration.getStartDate().clone();
        if(this.configuration.isWithinTimeSpan(day)) {
            while(tmpDate.get(GregorianCalendar.YEAR) < day.get(GregorianCalendar.YEAR)) {
                reportNr += tmpDate.getWeeksInWeekYear();
                tmpDate.add(GregorianCalendar.YEAR, 1);
            }
            while(tmpDate.get(GregorianCalendar.WEEK_OF_YEAR) < day.get(GregorianCalendar.WEEK_OF_YEAR)) {
                reportNr++;
                tmpDate.add(GregorianCalendar.WEEK_OF_YEAR, 1);
            }
        } else {
            throw new Exception("Report Date is not within training time!");
        }
        return reportNr + 1;
    }
    
    public GregorianCalendar getDateByReportNr(int reportNr) throws Exception {
        reportNr -= 1;
        GregorianCalendar reportNrDate = (GregorianCalendar)this.configuration.getStartDate().clone();
        reportNrDate.add(GregorianCalendar.WEEK_OF_YEAR, reportNr);
        reportNrDate.set(GregorianCalendar.DAY_OF_WEEK, reportNrDate.getFirstDayOfWeek());
        if(!this.configuration.isWithinTimeSpan(reportNrDate)) {
            throw new Exception("Report Date is not within training time!");
        }
        return reportNrDate;
    }
    
    public ConsoleInput processInput(ConsoleInput consoleInput) throws Exception {
        switch(consoleInput.getData().consoleInputMode) {
            case DATE:
                consoleInput.getData().inputReportNumbers = new AbstractMap.SimpleEntry<Integer, Integer>(this.getReportNrByDate(consoleInput.getData().inputDates.getKey()), 0);
                break;
            case REPORT_NR:
                consoleInput.getData().inputDates = new AbstractMap.SimpleEntry<GregorianCalendar, GregorianCalendar>(this.getDateByReportNr(consoleInput.getData().inputReportNumbers.getKey()), null);
                break;
            // TODO: handle other input types
        }
        return consoleInput;
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
