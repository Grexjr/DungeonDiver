package engine.gui;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractTextDisplayBox extends AbstractGUIComponent implements Writeable{

    private JTextArea textbox;
    private int columns,rows;

    public AbstractTextDisplayBox(){
        super(new JScrollPane());

        this.textbox = new JTextArea();
        this.columns = GUIConstants.TEXT_DISPLAY_DEFAULT_SIZE[0];
        this.rows = GUIConstants.TEXT_DISPLAY_DEFAULT_SIZE[1];

        this.textbox.setColumns(this.columns);
        this.textbox.setRows(this.rows);
        this.textbox.setLineWrap(true);
        this.textbox.setEditable(false);
        this.textbox.setFocusable(false);

        getComponent().setViewportView(this.textbox);
        getComponent().setPreferredSize(this.textbox.getPreferredSize());
    }

    //
    // Interface methods
    //
    @Override
    public final void setText(String newText) {
        this.textbox.setText(newText);
        refresh();
        scrollDown();
    }

    @Override
    public final void write(String text) {
        this.textbox.append(text);
        refresh();
        scrollDown();
    }

    @Override
    public final void erase(int start, int end) {
        this.textbox.replaceRange("",start,end);
        refresh();
        scrollDown();
    }

    @Override
    public final void replaceText(String text, int start, int end) {
        this.textbox.replaceRange(text,start,end);
        refresh();
        scrollDown();
    }

    @Override
    public final void slowWrite(String text) {
        char[] textArray = text.toCharArray();
        for(int i = 0; i < textArray.length; i++){
            write(String.valueOf(textArray[i]));
            try {
                Thread.sleep(GUIConstants.TEXT_WRITE_DELAY);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            if(i == textArray.length - 1){
                write("\n");
            }
        }
    }

    //
    // Override methods
    //
    @Override
    protected final JScrollPane getComponent(){return (JScrollPane) super.getComponent();}

    /**
     * Get the width of the text box in units of columns.
     * @return the number of columns the text box has.
     */
    @Override
    public final int getWidth(){return this.columns;}

    /**
     * Get the height of the text box in units of rows.
     * @return the number of rows the text box has
     */
    @Override
    public final int getHeight(){return this.rows;}

    @Override
    public final void setWidth(int columns){
        this.columns = columns;
        this.textbox.setColumns(this.columns);
        refresh();
        refreshScroller();
    }

    @Override
    public final void setHeight(int rows){
        this.rows = rows;
        this.textbox.setRows(this.rows);
        refresh();
        refreshScroller();
    }

    //
    // Class methods
    //

    private void refreshScroller(){
        getComponent().repaint();
        getComponent().revalidate();
    }

    public void scrollDown() {
        SwingUtilities.invokeLater(() -> {
            JScrollBar scroller = getComponent().getVerticalScrollBar();
            scroller.setValue(scroller.getMaximum());
            refresh();
            //refreshScroller();}
        });
    }

}
