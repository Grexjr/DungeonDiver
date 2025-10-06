package Tester.testobjects;

import engine.gui.AbstractScreen;

public class TestScreen extends AbstractScreen {

    public TestScreen(){

    }


    @Override
    public void onCreate() {
        System.out.println("Screen created");
    }

    @Override
    public void onDestroy() {
        System.out.println("Screen destroyed");
    }
}
