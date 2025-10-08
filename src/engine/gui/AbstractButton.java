package engine.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractButton extends AbstractGUIComponent implements Inputtable{

    public AbstractButton(){
        super(new JButton());

        // Initializing the button
        this.getComponent().addActionListener(addAction());
        int defaultWidth = GUIConstants.BUTTON_DEFAULT_SIZE[0];
        int defaultHeight = GUIConstants.BUTTON_DEFAULT_SIZE[1];
        this.getComponent().setPreferredSize(new Dimension(defaultWidth,defaultHeight));
        setWidth(defaultWidth);
        setHeight(defaultHeight);
    }

    //
    // Override methods
    //
    @Override
    public final void setText(String newText) {
        this.getComponent().setText(newText);
        //refresh();
    }

    @Override
    public final int getWidth(){return super.getWidth();}

    @Override
    public final int getHeight(){return super.getHeight();}

    @Override
    public final void setWidth(int newWidth){
        super.setWidth(newWidth);
        getComponent().setPreferredSize(new Dimension(getWidth(),getHeight()));
        refresh();
    }

    @Override
    public final void setHeight(int newHeight){
        super.setHeight(newHeight);
        getComponent().setSize(getWidth(),getHeight());
        //refresh();
    }

    @Override
    public final ActionListener addAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onInput();
            }
        };
    }

    //
    // Class methods
    //
    @Override
    protected final JButton getComponent(){return (JButton) super.getComponent();}

    public final void addLabel(AbstractLabel label){
        getComponent().add(label.getComponent());
        refresh();
    }

}
