import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    private ArrayList<T> items;

    public Box(T... items) {
        this.items = new ArrayList<T>(Arrays.asList(items));
    }

    //вычисляем вес коробки
    public float getWeight() {
        if (items.size() == 0) return 0;
        float weight = 0;
        for (T item : items) weight += item.getWeight();
        return weight;
    }

    //сравнение
    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    //перенос
    public void clear() {
        items.clear();
    }

    public void transfer(Box<? super T> box) {
        box.items.addAll(this.items);
        clear();
    }

    public ArrayList<T> getItems() {
        return new ArrayList<T>(items);
    }

    public void add(T... items) {
        this.items.addAll(Arrays.asList(items));
    }

    public void remove(T... items) {
        for (T item : items) this.items.remove(item);
    }

}
