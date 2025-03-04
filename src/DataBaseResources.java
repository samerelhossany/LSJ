import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DataBaseResources {

    private static final Map<String, String> DATA_TYPES_HASH_MAP;
    static {
        Gson gson = new GsonBuilder().create();

        Reader reader = new InputStreamReader(getFileFromResources("DataTypes.json"));
        HashMap<String, String> temp;
        temp = gson.fromJson(reader, HashMap.class);
        DATA_TYPES_HASH_MAP = Collections.unmodifiableMap(temp);


    }

    public static String getJavaDataType(String swiftDataType){
        return DATA_TYPES_HASH_MAP.get(swiftDataType);

    }
    private DataBaseResources(){}


    private static InputStream getFileFromResources(String fileName) {
        InputStream is = DataBaseResources.class.getClassLoader().getResourceAsStream(fileName);
        return is;
    }
}
