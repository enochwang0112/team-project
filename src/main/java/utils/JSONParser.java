package utils;

import org.json.JSONObject;

import java.util.logging.Logger;


public class JSONParser {
    private static final Logger logger = Logger.getLogger(JSONParser.class.getName());

    /**
     * Finds the value of key within JSON.
     *
     * @param key  The key to look for.
     * @param JSON The JSON string to look through.
     * @return     The value at key.
     */
    public Object findProperty(String key, String JSON){
        try{
            JSONObject json = new JSONObject(JSON);
            return json.get(key);
        } catch (Exception e) {
            logger.warning(e.getMessage());
            return "";
        }
    }

    /**
     * Creates a new JSON String with a single property.
     *
     * @param key   The key of the property.
     * @param value Value of the property.
     * @return      A JSON string with the above key-value pair.
     */
    public static String createSingleJSON(String key, Object value){
        try {
            JSONObject json = new JSONObject();
            json.put(key, value);
            return json.toString();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            return "";
        }
    }
}
