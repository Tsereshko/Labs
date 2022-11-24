package Factory;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Control;

public class ButtonFactory extends AbstractFactory{
    @Override
    public Control createComponent(String title) {
        return new Button(title);
    }

    @Override
    public Control createComponent(String title, int x, int y) {
        Button button = new Button(title);
        setup(button, x, y);
        return button;
    }

    public Control createComponent(String str, int x, int y, EventHandler<ActionEvent> eventHandler){
        Button button = new Button(str);
        setup(button, x, y);
        button.setOnAction(eventHandler);
        return button;
    }
    public Control createComponent(String str, EventHandler<ActionEvent> eventHandler){
        Button button = new Button(str);
        button.setOnAction(eventHandler);
        return button;
    }
}
