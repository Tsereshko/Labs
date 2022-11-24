package Geometry;

import java.util.ArrayList;

public class Triangle extends Figure{
    public Triangle(ArrayList<Point> arrayList){
        this.arrayList = arrayList;
        linesCreate();
    }
    public String info(){
        String info = "";
        if (isRectangular())
            info += "Прямоугольный ";
        if(isIsosceles())
            info +="Равнобедренный ";
        if(isEquilateral())
            info +="Равносторонний ";
        if(info.equals("")){
            info = "Разносторонний ";
        }

        return info;
    }

    private boolean isRectangular(){
        int hypotenuseIndex = 0;
        for(int i = 1; i<3; i++){
            if(lines[hypotenuseIndex].getDistance() < lines[i].getDistance())
                hypotenuseIndex = i;
        }
        double sum = 0;
        for (int i = 0; i<3; i++){
            if(i != hypotenuseIndex){
                sum += lines[i].getDistance() * lines[i].getDistance();
            }
        }
        return Math.sqrt(sum) == lines[hypotenuseIndex].getDistance();
    }
    private boolean isIsosceles(){
        return lines[0].getDistance() == lines[1].getDistance()
                || lines[0].getDistance() == lines[2].getDistance()
                || lines[1].getDistance() == lines[2].getDistance();
    }
    private boolean isEquilateral(){
        return lines[0].getDistance() == lines[1].getDistance()
                &&lines[0].getDistance() == lines[2].getDistance();

    }
}
