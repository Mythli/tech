/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 *
 * @author Tobias
 */
public abstract class FileConfigurationProvider extends AbstractConfigurationProvider {
    public String getConfigFileName() {
        return "infotrepo.conf";
    }
    
    protected final String getApplicationDirectory() {
        return System.getProperty("user.dir");
    }  
    
    public String getFullConfigFileName() {
        return this.getApplicationDirectory()+"/"+getConfigFileName();
    }
    
    protected final String readFile(String path) throws IOException {
        FileInputStream stream = new FileInputStream(new File(path));
        try {
          FileChannel fc = stream.getChannel();
          MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
          /* Instead of using default, pass in a decoder. */
          return Charset.defaultCharset().decode(bb).toString();
        }
        finally {
          stream.close();
        }
    }
    
    protected final String readConfigFile() throws ConfigurationProviderIOException {
        try {
            return this.readFile(this.getFullConfigFileName());
        } catch(IOException ex) {
            throw new ConfigurationProviderIOException("Failed to load configuration!", ex);
        }
    }
    
    protected final void writeString(String fileName, String str) throws FileNotFoundException {
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(fileName));
            out.print(str);
        }
        finally {
            if (out != null) {
                out.close();
            }
        }
    }
    
    protected final void writeConfigFile(String configStr) {
        try {
            this.writeString(this.getFullConfigFileName(), configStr);
        } catch(FileNotFoundException ex) {
            throw new ConfigurationProviderIOException("Failed to load configuration!", ex);
        }
    }
}
