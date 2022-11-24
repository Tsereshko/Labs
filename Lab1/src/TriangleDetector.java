import Geometry.Point;
import Geometry.Triangle;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class TriangleDetector {
    static Function functions = new Function();

    public static void main(String[] args) throws IOException {
        ArrayList<Point> arrayList;
        int choice;


        while (true) {
            arrayList = new ArrayList<>();
            System.out.println("""
                    Способ ввода точек треугольника
                    1.Ручной ввод
                    2.Случайные значения
                    3.Файл""");
            choice = functions.enterChoiceMenu(1, 3);
            switch (choice) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        arrayList.add(i, functions.enterPoint());
                    }
                    break;
                case 2:
                    for (int i = 0; i < 3; i++) {
                        arrayList.add(i, functions.randomPoint());
                    }
                    break;
                case 3:
                    arrayList = functions.readPointFromFile(functions.FILE1);
                    break;
            }



            Triangle triangle = new Triangle(arrayList);
            System.out.println(triangle.info());

            functions.writeFile(functions.FILE2, triangle.info(),false);
            functions.writeFile(functions.FILE3,  arrayList.toString() + '\n' + triangle.info(), false);

            System.out.println("1.Ещё раз\n2.Выход из программы");
            if (functions.enterChoiceMenu(1, 2) == 2) return;
        }
    }




}
