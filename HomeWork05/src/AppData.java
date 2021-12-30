import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

/*
Для хранения данных использовать класс вида:
public class AppData {
  private String[] header;
  private int[][] data;
 // ...
}
 */

public class AppData implements Serializable {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void save(File file) { //запись данных в файл и сохранение файла
        try (BufferedWriter bufferedWriter = //открываем файл на запись
                     new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(header[0] + ";" + header[1] + ";" + header[2] + "\n");
            for (int i = 0; i < data.length; i++) {
                bufferedWriter.write(data[i][0] + ";" + data[i][1] + ";" + data[i][2] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(File file) { //чтение данных из файла

        ArrayList<Integer>  arrayList = new ArrayList<>();

        //читаем файл построчно:
        try (BufferedReader bufferedReader = //открываем файл
                     new BufferedReader(new FileReader(file))) {
            //чтение header
            String dataLine;
            header = bufferedReader.readLine().split(";");

            // узнаем количество строк
//            int countLines = 0;
//            while ((dataLine = bufferedReader.readLine()) != null) {
//                countLines++;
//            }
            this.data = new int[2][3]; //создаем массив

            // работа с данными
            for (int i = 0; i < 2; i++) {
                //заполняем данные из массива:
                String[] tmp = bufferedReader.readLine().split(";");
                for (int j = 0; j < 3; j++) {
                    this.data[i][j] = Integer.parseInt(tmp[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readAppData() {
        for (String s : header) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (int[] ints : data) {
            for (int num : ints) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}