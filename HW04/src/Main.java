import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

//1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся)

        System.out.println("***** Задание 1 *****");
        String[] arrayWords = new String[]{"One", "Two", "Three", "Three", "Two",
                "Two", "Three", "Four", "Five", "Three", "Four"};
        System.out.print("Исходный набор слов: ");
        for (String str : arrayWords) {
            System.out.print(str + " ");
        }
        System.out.println();

// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем)
// Посчитать, сколько раз встречается каждое слово

        HashMap<String, Integer> uniq = new HashMap<>();
        System.out.print("Уникальные значения: ");
        for (String str : arrayWords) {
            uniq.merge(str, 1, Integer::sum);
        }
        System.out.println(uniq);

//        //Исходный мой код:

//        HashMap<String, Integer> uniq = new HashMap<>();
//        System.out.print("Уникальные значения: ");
//        for (String str : arrayWords) {
//            if (uniq.get(str) == null) {
//                uniq.put(str, 1);
//            }
//            else {
//                uniq.put(str, uniq.get(str) + 1);
//            }
//        }
//        System.out.println(uniq);

        //альтернатива: вывод уникальных значений с помощью HashSet
        System.out.print("Уникальные значения с помощью HashSet: ");
        HashSet<String> uniqAlternative = new HashSet<>(Arrays.asList(arrayWords));
        System.out.println(uniqAlternative);

//        2. Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
//        В этот телефонный справочник с помощью метода add() можно добавлять записи,
//        а с помощью метода get() искать номер телефона по фамилии.
//        Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//        тогда при запросе такой фамилии должны выводиться все телефоны.
//        Консоль использовать только для вывода результатов проверки телефонного справочника.

        System.out.println("***** Задание 2 *****");

        PhoneBook phoneBookObject = new PhoneBook();
        phoneBookObject.add("12345", "Ivanov");
        phoneBookObject.add("555", "Ivanov");
        phoneBookObject.add("1111", "Serov");
        phoneBookObject.add("987", "Kirov");
        phoneBookObject.add("55556", "Gurov");

        //поиск по фамилии
        phoneBookObject.get("Ivanov");
        phoneBookObject.get("Serov");

    }
}
