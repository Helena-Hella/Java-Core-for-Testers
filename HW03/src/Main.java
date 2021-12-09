import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Задание 1
        System.out.println("Задание 1. Поменять местами элементы.");
        String[] myArray = {"One", "Two", "Three", "Four", "Five"};
        System.out.print("Исходный массив: ");
        printArray(myArray);
        System.out.println();
        swapElements(myArray, 2, 3);
        System.out.print("Массив после замены: ");
        printArray(myArray);
        System.out.println();

        //Задание 2
        System.out.println();
        System.out.println("Задание 2. Которое с коробками...");

        System.out.println("Три яблока и три апельсина:");
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        Box<Apple> box1 = new Box<>(apple1, apple2, apple3);
        Box<Orange> box2 = new Box<>(orange1, orange2, orange3);

        System.out.println("Коробка 1: " + box1.getItems());
        System.out.println("Коробка 2: " + box2.getItems());

        System.out.println("Вес одинаковый? " + box1.compare(box2));

        //пересыпаем апельсины из 2 в 3 коробку
        System.out.println("Пересыпаем апельсины из 2 в 3 коробку:");
        Box<Orange> box3 = new Box<>();
        box2.transfer(box3);

        System.out.println("Коробка 1: " + box1.getItems());
        System.out.println("Коробка 3: " + box3.getItems());

    }

    //выводим на экран стринговый массив
    public static void printArray(String[] inputArray) {
        for (int i = 0; i < 5; i++) {
            System.out.print(inputArray[i] + "\t");
        }
    }

    //меняем местами элементы стрингового массива
    private static <T> void swapElements(T[] array, int id1, int id2) {
        T temp = array[id1];
        array[id1] = array[id2];
        array[id2] = temp;
    }

}
