package homeworkFiveSix.taskTwo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

class PropUse {
    private Properties properties = new Properties();
    private boolean isLoaded = false;

    Map addObjects(String fileName) {
        Set<String> keyNames = properties.stringPropertyNames();
        Map<String, String> propCollection = new HashMap<>();
        Iterator<String> itr;

        if (!isLoaded) {
            load(fileName);
        }

        itr = keyNames.iterator();

        while (itr.hasNext()) {
            String key = itr.next();
            if (propCollection.containsKey(key)) {
                System.out.println("key is already exists in collection");
            }
            propCollection.put(key, properties.getProperty(key));
        }

        return propCollection;
    }

    void load(String fileName) {
        try {
            if (!isLoaded) {
                properties.load(new FileInputStream(fileName));
                isLoaded = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String findKey(String key) throws IOException {
        String resultKey = properties.getProperty(key);
        if (resultKey == null) {
            throw new IOException("key not found");
        }
        return resultKey;
    }


}
