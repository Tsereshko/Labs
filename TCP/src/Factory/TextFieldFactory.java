package Factory;

import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TextFieldFactory extends AbstractFactory {
    @Override
    public Control createComponent(String title) {
        return new TextField(title);
    }

    public Control createComponent(String title, int x, int y) {
        TextField textField = new TextField(title);
        setup(textField, x, y);
        return textField;
    }
}
