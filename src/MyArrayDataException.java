public class MyArrayDataException extends RuntimeException {
    int i, j;

    public MyArrayDataException(int i, int j) {
        super("Неверные данные в ячейке с индексами строка: " + i + ", стобец: " + j);
        this.i = i;
        this.j = j;
    }
}