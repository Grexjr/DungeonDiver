package Tester.testobjects;

import engine.gui.AbstractPanel;

import java.awt.*;

public class TestTextPanel extends AbstractPanel {

    public TestTextPanel(){
        this.setLayout(new FlowLayout());
    }

    @Override
    public void onCreate() {
        System.out.println("Test Panel created");
    }

    @Override
    public void onDestroy() {
        System.out.println("Test Panel destroyed");
    }
}
