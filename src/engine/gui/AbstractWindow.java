package engine.gui;

import javax.swing.*;

public abstract class AbstractWindow implements Displayable {

    private final JFrame frame;
    private String title;
    private AbstractScreen screen;

    public AbstractWindow(){
        this.frame = new JFrame();
        this.title = GUIConstants.WINDOW_DEFAULT_TITLE;
        this.screen = new DefaultScreen();

        this.frame.setSize(GUIConstants.WINDOW_DEFAULT_SIZE[0], GUIConstants.WINDOW_DEFAULT_SIZE[1]);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setTitle(this.title);
        this.frame.setContentPane(this.screen.getContainerPanel());
    }

    //
    // Interface methods | TODO Maybe move these to an abstract GUIObject class
    //
    @Override
    public final void show() {
        this.frame.setVisible(true);
    }

    @Override
    public final void hide() {
        this.frame.setVisible(false);
    }

    @Override
    public final void refresh(){
        this.frame.repaint();
        this.frame.revalidate();
    }

    //
    // Class methods
    //
    public final void setTitle(String title){
        this.title = title;
        this.frame.setTitle(this.title);
    }

    public final void setScreen(AbstractScreen screen){
        this.screen = screen;
        this.frame.setContentPane(screen.getContainerPanel());
    }
}
