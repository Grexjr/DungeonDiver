package Tester.testobjects;

import engine.gui.AbstractTextDisplayBox;

public class TestTextBox extends AbstractTextDisplayBox {

    @Override
    public void onCreate() {
        write("Hello World!");
    }

    @Override
    public void onDestroy() {
        System.out.println("Text Display Destroyed");
    }

}
