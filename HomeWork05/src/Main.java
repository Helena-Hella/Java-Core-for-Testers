import java.io.File;

public class Main {
    public static void main(String[] args) {

        File file = new File("Result.csv");

        String[] header = {"Value 1", "Value 2", "Value 3"};

        int[][] data = {{100, 200, 123}, {300, 400, 500}};

        AppData appData = new AppData(header, data);

        appData.save(file);
        appData.load(file);
        appData.readAppData();
    }


}
