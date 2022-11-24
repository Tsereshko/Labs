package Factory;

import javafx.scene.control.Control;
import javafx.scene.control.Label;

public class LabelFactory extends AbstractFactory{
    @Override
    public Control createComponent(String title) {
        return new Label(title);
    }

    @Override
    public Control createComponent(String title, int x, int y) {
        Label label = new Label(title);
        setup(label, x, y);
        return label;
    }
}
