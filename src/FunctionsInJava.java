import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class FunctionsInJava {

    private static final Map<String, Map<String ,String>> DATA_TYPES_HASH_MAP;
    static {
        Gson gson = new GsonBuilder().create();
        Reader reader = new InputStreamReader(getFileFromResources("functionsInJava.json"));
        HashMap<String, Map<String,String>> temp;
        temp = gson.fromJson(reader, HashMap.class);
        DATA_TYPES_HASH_MAP = Collections.unmodifiableMap(temp);
    }

    public static String getJavafunctions(String outermap,String innermap){
        String swiftfunctions;
        swiftfunctions = DATA_TYPES_HASH_MAP.get(outermap).get(innermap);
        return(swiftfunctions);
    }
    private FunctionsInJava(){}


    private static InputStream getFileFromResources(String fileName) {
        InputStream is = DataBaseResources.class.getClassLoader().getResourceAsStream(fileName);
        return is;
    }
}

