package homeworkFour.taskThree;

import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import homeworkFour.taskOne.ByteIO;

import java.io.*;

public class CharByteIO {
    StringBuilder readFile(String fileName) {
        StringBuilder textFromFile = new StringBuilder();
        BufferedReader r = null;
        try {
            r = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "cp1251"));
            while (r.ready()){
                String line = r.readLine();
                textFromFile.append(line);
            }
            r.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return textFromFile;
    }

    void writeInFile(String fileName){

    }


}

