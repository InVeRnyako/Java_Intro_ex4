import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

// Пусть дан список сотрудников. Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

public class ex1 {
    public static void main(String[] args) {
        ArrayList<String> fullNameList = getNamesListfromFile();
        HashMap<String, Integer> uniqueNames = countUniqueNames(fullNameList);

        Map<String, Integer> sorted = uniqueNames
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));
        System.out.println(sorted);
    }

    public static ArrayList<String> getNamesListfromFile() {
        BufferedReader reader;
        ArrayList<String> namesArrayList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("ex1_data.txt", StandardCharsets.UTF_8));
            String line = reader.readLine();

            while (line != null) {
                if (line.length() > 1)
                    namesArrayList.add(line);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return namesArrayList;
    }

    public static HashMap<String, Integer> countUniqueNames(ArrayList<String> fullNameList) {
        HashMap<String, Integer> nameCount = new HashMap<>();
        String[] temp = { "", "" };
        for (String string : fullNameList) {
            temp = string.split(" ");
            if (nameCount.containsKey(temp[0])) {
                nameCount.put(temp[0], nameCount.get(temp[0]) + 1);
            } else {
                nameCount.put(temp[0], 1);
            }
        }
        return nameCount;
    }
}
