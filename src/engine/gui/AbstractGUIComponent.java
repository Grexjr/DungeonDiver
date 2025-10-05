package engine.gui;

import javax.swing.*;

public abstract class AbstractGUIComponent implements Displayable, Outputable{

    private JComponent component;
    private String text;
    private int width;
    private int height;

    protected AbstractGUIComponent(JComponent component){
        this.component = component;
        this.text = GUIConstants.COMPONENT_DEFAULT_TEXT;
    }

    //
    // Interface methods
    //
    @Override
    public final void show() {
        this.component.setVisible(true);
    }

    @Override
    public final void hide() {
        this.component.setVisible(false);
    }

    @Override
    public final void refresh() {
        this.component.repaint();
    }

    @Override
    public final void init() {
        onCreate();
    }

    @Override
    public final void terminate() {
        onDestroy();
    }

    //
    // Class methods
    //
    protected JComponent getComponent(){return this.component;}
    public final String getText(){return this.text;}
    public int getWidth(){return this.width;}
    public int getHeight(){return this.height;}

    public void setWidth(int newWidth){
        this.width = newWidth;
        this.component.setSize(this.width,this.height);
        refresh();
    }
    public void setHeight(int newHeight){
        this.height = newHeight;
        this.component.setSize(this.width,this.height);
        refresh();
    }

    public abstract void setText(String newText);



}
