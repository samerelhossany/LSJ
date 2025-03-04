import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class built_in_methods {

    private static final Map<String, String> DATA_TYPES_HASH_MAP;
    static {
        Gson gson = new GsonBuilder().create();

        Reader reader = new InputStreamReader(getFileFromResources("methods.json"));
        HashMap<String, String> temp;
        temp = gson.fromJson(reader, HashMap.class);
        DATA_TYPES_HASH_MAP = Collections.unmodifiableMap(temp);


    }

    public static String getJavamethod(String swiftmethod){
        return DATA_TYPES_HASH_MAP.get(swiftmethod);

    }
    private built_in_methods(){}


    private static InputStream getFileFromResources(String fileName) {
        InputStream is = DataBaseResources.class.getClassLoader().getResourceAsStream(fileName);
        return is;
    }
}

