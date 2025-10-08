package engine.gui;

import javax.swing.*;

public abstract class AbstractLabel extends AbstractGUIComponent {

    public AbstractLabel(){
        super(new JLabel(GUIConstants.LABEL_DEFAULT_TEXT));
    }

    //
    // Interface/Override methods
    //
    @Override
    public void setText(String newText) {

    }

    @Override
    public void onCreate() {
        System.out.println(this + "Created!");
    }

    @Override
    public void onDestroy() {
        System.out.println(this + "Destroyed!");
    }

    @Override
    protected final JLabel getComponent(){return (JLabel)super.getComponent();}


}
