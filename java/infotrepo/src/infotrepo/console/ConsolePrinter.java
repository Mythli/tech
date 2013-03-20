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
        this.printMessage("Bitte gib die benötigten Daten zur Informationsverarbeitung ein.");
        this.printMessage("Berichtsheftnummer, Datumumswerte und, Zeitspannen von Berichtsheftnummern (und/ oder) Datumswerten können verarbeitet werden.");
        this.printMessage("");
    }
    
    public void printRequestIsInProcess() {
        this.printMessage("Bitte habe einen Augenblick Geduld. Deine Anfrage wird bearbeitet.");
        this.printMessage("");
    }
    
    public void printGoodbyeMessage() {
        this.printMessage("Vielen dank für die Benutzung von infoTrepo dem cleveren Berichtsheftinformationsprogramm.");
        this.printMessage("");
        try {
            Thread.currentThread().sleep(500);
        } catch(InterruptedException ex ) { }
    }
    
    public void printInputMissmatch() {
        this.printMessage("Das tut uns leid. Deine Eingabe konnte nicht verarbeitet werden.");
        this.printMessage("");
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
