package homeworkFive.taskTwo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class PropUse {
    private Properties properties = new Properties();
    private boolean isLoaded = false;

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
