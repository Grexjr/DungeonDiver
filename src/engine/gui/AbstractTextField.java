package engine.gui;

import javax.swing.*;

public abstract class AbstractTextField extends AbstractGUIComponent implements Inputtable{

    public AbstractTextField(){
        super(new JTextField(GUIConstants.TEXT_FIELD_DEFAULT_SIZE));
    }




}
