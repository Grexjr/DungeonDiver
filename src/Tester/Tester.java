package Tester;

import Tester.testobjects.*;

import java.awt.*;

public class Tester {

    public static void main(String[] args){

        TestWindow window = new TestWindow();
        TestScreen screen =  new TestScreen();
        screen.init();
        TestTextPanel textPanel = new TestTextPanel();
        textPanel.init();
        TestButtonPanel buttonPanel = new TestButtonPanel();
        buttonPanel.init();
        TestTextBox textBox = new TestTextBox();
        textBox.init();
        TestButton button = new TestButton();
        button.init();

        window.setScreen(screen);
        window.refresh();

        System.out.println("ADDING TEXT PANEL");
        screen.addComponent(textPanel, BorderLayout.NORTH);

        System.out.println("ADDING BUTTON PANEL");
        screen.addComponent(buttonPanel,BorderLayout.SOUTH);
        screen.refresh();

        System.out.println("ADDING TEXT BOX");
        textPanel.addComponent(textBox,BorderLayout.CENTER);
        textPanel.refresh();

        System.out.println("ADDING BUTTON");
        buttonPanel.addComponent(button,BorderLayout.CENTER);
        buttonPanel.refresh();

        window.show();





    }




}
