package Factory;

import javafx.scene.control.Control;
import javafx.scene.control.TextArea;

public class TextAreaFactory extends AbstractFactory {
    @Override
    public Control createComponent(String title) {
        return new TextArea(title);
    }

    @Override
    public Control createComponent(String title, int x, int y) {
        TextArea textArea = new TextArea(title);
        setup(textArea, x, y);
        return textArea;
    }
}
