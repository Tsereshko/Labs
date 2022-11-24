package Factory;

import javafx.scene.control.Control;

public abstract class AbstractFactory {
    public abstract Control createComponent(String title);
    public abstract Control createComponent(String title, int x, int y);

    protected void setup(Control control, int x, int y){
        control.setLayoutX(x);
        control.setLayoutY(y);
    }

}
