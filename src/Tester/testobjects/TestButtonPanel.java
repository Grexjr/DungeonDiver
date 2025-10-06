package Tester.testobjects;

import engine.gui.AbstractPanel;

public class TestButtonPanel extends AbstractPanel {

    @Override
    public void onCreate() {
        System.out.println("button panel created!");
    }

    @Override
    public void onDestroy() {
        System.out.println("button panel destroyed");
    }

}
