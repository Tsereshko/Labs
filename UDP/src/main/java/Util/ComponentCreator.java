package Util;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class ComponentCreator {
    static TextField createTextField(String str, int x, int y){
        TextField textField = new TextField(str);
        setup(textField, x, y);
        return textField;
    }
    static TextArea createTextArea(String str, int x, int y){
        TextArea textArea = new TextArea(str);
        setup(textArea, x, y);
        return textArea;
    }
    static Label createLabel(String str, int x, int y){
        Label label = new Label(str);
        setup(label, x, y);
        return label;
    }
    static Button createButton(String str, int x, int y, EventHandler<ActionEvent> eventHandler){
        Button button = new Button(str);
        setup(button, x, y);
        button.setOnAction(eventHandler);
        return button;
    }


    static TextField createTextField(String str){
        return new TextField(str);
    }
    static TextArea createTextArea(String str){
        return new TextArea(str);
    }
    static Label createLabel(String str){
        return new Label(str);
    }
    static Button createButton(String str, EventHandler<ActionEvent> eventHandler){
        Button button = new Button(str);
        button.setOnAction(eventHandler);
        return button;
    }

    static private void setup(Control control, int x, int y){
        control.setLayoutX(x);
        control.setLayoutY(y);
    }
}

