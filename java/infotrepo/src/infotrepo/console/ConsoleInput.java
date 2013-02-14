package infotrepo.console;

public class ConsoleInput {
    private ConsoleInputData data;
    
    public ConsoleInput() {
        
    }
    
    public ConsoleInput(ConsoleInputData data) {
        this.setData(data);
    }

    
    
    /**
     * @return the data
     */
    public ConsoleInputData getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(ConsoleInputData data) {
        this.data = data;
    }
}
