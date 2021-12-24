import java.util.HashMap;
import java.util.Map;

// 2. Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.

public class PhoneBook {

    HashMap<String, String> itemsOfTheBook;

    public PhoneBook() {
        itemsOfTheBook = new HashMap<>();
    }

    public HashMap<String, String> getItemsOfTheBook() {
        return itemsOfTheBook;
    }

    public void setItemsOfTheBook(HashMap<String, String> itemsOfTheBook) {
        this.itemsOfTheBook = itemsOfTheBook;
    }

    // В этот телефонный справочник с помощью метода add() можно добавлять записи
    public void add(String phone, String name) {
        itemsOfTheBook.put(phone, name);
    }

    // с помощью метода get() искать номер телефона по фамилии
    // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
    // тогда при запросе такой фамилии должны выводиться все телефоны.

    public void get(String nameToFind) {
        for (Map.Entry<String, String> element : itemsOfTheBook.entrySet()) {
            if (element.getValue().equals(nameToFind)) {
                System.out.println(element.getValue() + " " + element.getKey());
            }
        }
    }
}
