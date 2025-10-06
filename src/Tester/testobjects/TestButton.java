package Tester.testobjects;

import engine.gui.AbstractButton;

public class TestButton extends AbstractButton {

    @Override
    public void onInput() {
        System.out.println("Input pressed!");
    }

    @Override
    public void onCreate() {
        System.out.println("Button made!");
    }

    @Override
    public void onDestroy() {
        System.out.println("Button destroyed");
    }
}
