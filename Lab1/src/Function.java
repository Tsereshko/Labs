import Geometry.Point;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Function {
    final String FILE_PATH="D:\\projects\\JavaUnic\\Lab1\\src\\";
    final String FILE1 = FILE_PATH+"file1";
    final String FILE2 = FILE_PATH+"file2";
    final String FILE3 = FILE_PATH+"file3";

    Point randomPoint() {
        return new Point(
                new Random().nextDouble(100.0),
                new Random().nextDouble(100.0)
        );
    }
    ArrayList<Point> readPointFromFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fileReader);
        ArrayList<Point> arrayList = new ArrayList<>();

        String line = br.readLine();
        String[] numbersStrings = line.split(",");
        double[] numbers = new double[numbersStrings.length];
        for (int i = 0; i < numbersStrings.length; i++) {
            numbers[i] = Double.parseDouble(numbersStrings[i]);
        }
        for(int i = 0, j = 1; j <6; i+=2, j+=2){
            arrayList.add(new Point(numbers[i], numbers[j]));
        }
        fileReader.close();
        return arrayList;
    }
    void writeFile(String fileName, String info, boolean append) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, append);
        fileWriter.write(info);
        fileWriter.flush();
    }
    int enterChoiceMenu(int a, int b) {
        int choice;
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                choice = Character.getNumericValue(br.read());
                if (choice < a || choice > b) throw new IOException();
                else return choice;
            } catch (IOException | NumberFormatException e) {
                System.out.println("неверный ввод.");
            }
        }
    }
    Point enterPoint() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double x, y;

        while (true) {
            try {
                System.out.print("Enter X : ");
                x = Double.parseDouble(br.readLine());
                System.out.print("Enter Y : ");
                y = Double.parseDouble(br.readLine());
                return new Point(x, y);
            } catch (java.lang.NumberFormatException exception) {
                System.out.println("Format error");
            }
        }
    }
    String arrayListToString(ArrayList<Point> arrayList){
        String str = "";
        for(int i = 0; i< arrayList.size(); i++){
            str+= arrayList.get(i).toString() + ",";
        }
        return str;
    }
}
