package engine.gui;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractScreen implements Displayable, Outputable{

    private final JPanel containerPanel;
    private LayoutManager layout;

    public AbstractScreen(){
        this.containerPanel = new JPanel();
        this.layout = GUIConstants.SCREEN_DEFAULT_LAYOUT;

        // Initialize the panel
        this.containerPanel.setLayout(this.layout);
    }

    //
    // Interface methods
    //
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
    public final void init(){
        onCreate();
    }

    @Override
    public final void terminate(){
        this.containerPanel.removeAll();
        onDestroy();
    }

    //
    // Class methods
    //
    protected JPanel getContainerPanel(){return this.containerPanel;}
    protected LayoutManager getLayout(){return this.layout;}

    public void setLayout(LayoutManager newLayout){
        this.layout = newLayout;
        this.containerPanel.setLayout(this.layout);
    }

    public void addComponent(AbstractPanel panel, Object constraints){
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
        System.out.println("Child: " + panel.getContainerPanel());
        if(this.getContainerPanel().equals(panel.getContainerPanel())){
            throw new IllegalArgumentException("FATAL FATAL FATAL");
        }*/
        this.getContainerPanel().add(panel.getContainerPanel(),constraints);
        refresh();
    }

}
