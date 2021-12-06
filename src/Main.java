
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int x;
        int y;

        System.out.print("Введите количество столбцов массива: ");
        x = scanner.nextInt();
        System.out.print("Введите количество строк массива: ");
        y = scanner.nextInt();

        String[][] newArray = new String[x][y];
        try {
            fillArray(newArray, x, y);
            System.out.println("Задан массив верного размера.");
            System.out.println("Сумма элементов составляет: " + summArray(newArray, x, y));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("А теперь заменим один из элементов на буквы:");
        try {
            changeData(newArray, x, y);
            summArray(newArray, x, y);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }
    // Заполнение и вывод массива
     public static void fillArray(String[][]array, int x, int y) {
        if (x != 4 || y != 4) throw new MyArraySizeException(x, y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                array[i][j] = "" + random.nextInt(9);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //Подменяем данные на символы
    private static void changeData (String[][] array, int x, int y){
        int tempi = random.nextInt(4);
        int tempj = random.nextInt(4);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                array[i][j] = "" + random.nextInt(9);
            }
        }
        array[tempi][tempj] = "ABC";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Подсичтываем сумму элементов
    private static int summArray(String[][] array, int x, int y) {
        int summ = 0;
        int[][] arrayInt = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                try {
                    arrayInt[i][j] = Integer.parseInt(array[i][j]);
                    summ += arrayInt[i][j];
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return summ;
    }

}

