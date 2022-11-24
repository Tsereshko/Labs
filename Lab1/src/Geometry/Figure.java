package Geometry;

import java.util.ArrayList;

abstract class Figure {
    protected ArrayList<Point> arrayList;
    protected Line[] lines;

    void linesCreate(){
        lines = new Line[arrayList.size()];
        for(int i = 0; i<arrayList.size() - 1; i++){
            lines[i] = new Line(arrayList.get(i), arrayList.get(i+1));
        }
        lines[arrayList.size()-1] = new Line(arrayList.get(arrayList.size()-1), arrayList.get(0));

        System.out.println(lines[0].getDistance());
        System.out.println(lines[1].getDistance());
        System.out.println(lines[2].getDistance());
    }
}
