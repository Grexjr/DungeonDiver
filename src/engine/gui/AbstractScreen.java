package engine.gui;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractScreen implements Displayable, Outputable{

    private final JPanel containerPanel;
    private LayoutManager layout;

    public AbstractScreen(){
        this.containerPanel = new JPanel();
        this.layout = GUIConstants.SCREEN_DEFAULT_LAYOUT;
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
}
