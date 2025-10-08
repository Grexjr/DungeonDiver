package engine.gui;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractPanel implements Displayable, Outputable, InputListener {

    private JPanel containerPanel;
    private LayoutManager layout;

    public AbstractPanel(){
        this.containerPanel = new JPanel();
        this.layout = new BorderLayout();

        this.containerPanel.setLayout(this.layout);
    }

    @Override
    public void show() {
        this.containerPanel.setVisible(true);
    }

    @Override
    public void hide() {
        this.containerPanel.setVisible(false);
    }

    @Override
    public void refresh() {
        this.containerPanel.repaint();
        this.containerPanel.revalidate();
    }

    @Override
    public void init() {
        onCreate();
    }

    @Override
    public void terminate() {
        onDestroy();
    }

    protected JPanel getContainerPanel(){return this.containerPanel;}

    public LayoutManager getLayout(){return this.layout;}

    public void setLayout(LayoutManager newLayout){
        this.layout = newLayout;
        this.containerPanel.setLayout(this.layout);
    }


    public void addComponent(AbstractGUIComponent component, Object constraints){
        LayoutManager layout = this.getContainerPanel().getLayout();

        if(layout instanceof BorderLayout){
            if(!(constraints instanceof String)){
                throw new IllegalArgumentException("BorderLayout expects a String!"); // DEBUG
            }
        } else if (layout instanceof GridBagLayout){
            if(!(constraints instanceof GridBagConstraints)){
                throw new IllegalArgumentException("GridBagLayout expects GridBagConstraints!"); //DEBUG
            }
        } else if (layout instanceof FlowLayout || layout instanceof GridLayout || layout instanceof BoxLayout){
            if(constraints != null){
                throw new IllegalArgumentException(layout.getClass().getSimpleName() + " does not accept constraints!");
            }
        }

        /*System.out.println("Parent: " + this.getContainerPanel());
        System.out.println("Child: " + component.getComponent());
        if(this.getContainerPanel().equals(component.getComponent())){
            throw new IllegalArgumentException("FATAL FATAL FATAL");
        }*/
        this.getContainerPanel().add(component.getComponent(),constraints);
        refresh();
    }

    @Override
    public void doAction(){
        System.out.println("Panel told to do something, define action in panel class.");
    }


}
