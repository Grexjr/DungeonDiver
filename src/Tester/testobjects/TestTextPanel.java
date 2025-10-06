package Tester.testobjects;

import engine.gui.AbstractPanel;

public class TestTextPanel extends AbstractPanel {

    public TestTextPanel(){

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
