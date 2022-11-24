package Util;

import java.util.concurrent.Callable;

public class TasksCreator {
    public static Callable getTask1(double a, double b){
        Callable  task = () -> {
            double result = 0;
            for (double n = a; n <= b; n++) {
                result += n / (n * n + n - 1);
            }
            return result;
        };
        return task;
    }
    public static Callable getTask2(double b, double c){
        Callable task = () ->{
            double result = 0;
            for(double n = b; n<=c; n++){
                result += n*n - 5;
            }
            return result;
        };
        return task;
    }
}
