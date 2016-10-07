package homeworkThree.taskThree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPictures {

    public boolean pictureSequenceCheck() throws IOException {
        String regex = "[РИСУНОКрисунок]{3,7}\\.?\\s\\d";
        Pattern p = Pattern.compile(regex);

        List<Integer> pictureNumbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(
                "D:\\Программы\\JavaFundamentals\\src\\main\\java\\homeworkThree\\taskThree\\article.html"))) {

            String line = null;

            while ((line = br.readLine()) != null) {
                Matcher m = p.matcher(line);

                while (m.find()) {
                    int start = m.start();
                    int end = m.end();
                    String picture = line.substring(start, end);
                    String[] numbers = picture.split("\\s");
                    for (int i = 1; i < numbers.length; i += 1) {
                        pictureNumbers.add(Integer.parseInt(numbers[i]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (pictureNumbers.get(0) > pictureNumbers.get(1)) {
            System.out.println("Автор ссылается на рисунки непоследовательно");
            return false;
        } else {
            System.out.println("Автор ссылается на рисунки последовательно");
            return true;
        }
    }
}