package Tester.testobjects;

import engine.gui.AbstractPanel;

import java.awt.*;

public class TestButtonPanel extends AbstractPanel {

    @Override
    public void onCreate() {
        System.out.println("button panel created!");
        this.setLayout(new FlowLayout());
    }

    @Override
    public void onDestroy() {
        System.out.println("button panel destroyed");
    }

}
