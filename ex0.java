import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
public class ex0 {
    public static void main(String[] args) {
        HashMap<String, List<Integer>> phoneBook = new HashMap<>();
        String name = "";
        Integer number = 0;
        while (true) {
            System.out.println("Введите имя: ");
            name = getStringInput();
            System.out.println("Введите новый телефон: ");
            number = getIntegerInput();
            if (phoneBook.containsKey(name))
                phoneBook.get(name).add(number);
            else {
                List<Integer> phones = new ArrayList<>();
                phones.add(number);
                phoneBook.put(name, phones);
            }
            System.out.println("Сохраненные номера:");
            System.out.println(phoneBook);
        }
    }

    public static String getStringInput() {
        String input = "";
        while (input.length() == 0) {

            input = System.console().readLine();

            if (input.length() == 0)
                System.out.println("Ошибка ввода.");
        }
        return input;
    }

    public static Integer getIntegerInput() {
        Integer input = 0;
        while (input < 1) {
            try {
                input = Integer.parseInt(System.console().readLine());
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Введите корректный номер");
            }
        }
        return input;
    }
}
