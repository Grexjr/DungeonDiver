package Tester.testobjects;

import engine.gui.AbstractButton;

public class TestButton extends AbstractButton {

    @Override
    public void onInput() {
        System.out.println("Input pressed!");
        this.setWidth(30);
    }

    @Override
    public void onCreate() {
        System.out.println("Button made!");
        this.setWidth(250);
        this.addLabel(new TestLabel());
    }

    @Override
    public void onDestroy() {
        System.out.println("Button destroyed");
    }
}
