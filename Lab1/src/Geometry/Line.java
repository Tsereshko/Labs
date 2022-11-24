package Geometry;

class Line {
    private Point start;
    private double distance;
    private Point end;

    public Line(Point start, Point end){
        this.start = start;
        this.end = end;
        this.distance = distance();
    }

    private double distance(){
        double x = start.getX() - end.getX();
        double y = start.getY() - end.getY();
        return Math.sqrt(x*x + y*y);
    }

    public double getDistance(){
        return distance;
    }
}
