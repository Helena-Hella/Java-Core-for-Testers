public class MyArraySizeException extends RuntimeException {

    int row, column;

    public MyArraySizeException(int row, int column) {
        super("Неверные данные. Количество строк и столбцов должно быть 4. Вы ввели строк: " + row + ", столбцов " + column);
        this.row = row;
        this.column = column;
    }
}