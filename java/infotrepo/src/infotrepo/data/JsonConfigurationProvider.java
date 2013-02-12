/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infotrepo.data;
import com.google.gson.*;

/**
 *
 * @author Tobias
 */
public class JsonConfigurationProvider extends FileConfigurationProvider {
    private Gson jsonSerializer;
    private ConfigurationData data;
    
    public JsonConfigurationProvider() {
        super();
        
        this.jsonSerializer = new GsonBuilder().setPrettyPrinting().create();
    }
    
    @Override
    public ConfigurationData getConfigurationData()  {
        this.data = new ConfigurationData();
        this.data = this.jsonSerializer.fromJson(this.readConfigFile(), this.data.getClass());
        
        return this.data;
    }

    @Override
    public void saveConfiguration() throws ConfigurationProviderIOException {
        String confStr = this.jsonSerializer.toJson(this.data);
        this.writeConfigFile(confStr);
    }
    
}
