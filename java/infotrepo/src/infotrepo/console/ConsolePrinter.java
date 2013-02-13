package infotrepo.console;
import java.io.PrintStream;
import java.lang.Thread;

public class ConsolePrinter {
    private PrintStream outputStream = System.out;
    
    public ConsolePrinter() {
        
    }
    
    public ConsolePrinter(PrintStream outputStream) {
        this.setOutputStream(outputStream);
    }
    
    public void printMessage(String message) {
        this.getOutputStream().println(message);
    }
    
    public void printHelloMessage() {
        this.printMessage("Willkommen bei infoTrepo dem cleveren Berichtsheftinformationsprogramm.");
        this.printMessage("");
    }
    
    public void printInpuDataInfoMessage() {
        this.printMessage("Bitte geben Sie die benötigten Daten zur Informationsverarbeitung ein.");
        this.printMessage("Berichtsheftnummer, Datumumswerte und, Zeitspannen von Berichtsheftnummern (und/ oder) Datumswerten können verarbeitet werden.");
        this.printMessage("");
    }
    
    public void printGoodbyeMessage() {
        this.printMessage("Vielen dank für die Benutzung von infoTrepo dem cleveren Berichtsheftinformationsprogramm.");
        this.printMessage("");
        try {
            Thread.currentThread().sleep(500);
        } catch(InterruptedException ex ) { }
    }

    /**
     * @return the outputStream
     */
    public PrintStream getOutputStream() {
        return outputStream;
    }

    /**
     * @param outputStream the outputStream to set
     */
    public void setOutputStream(PrintStream outputStream) {
        this.outputStream = outputStream;
    }
}
