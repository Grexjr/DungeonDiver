package engine.gui;

import javax.swing.*;

public abstract class AbstractTextDisplayBox extends AbstractGUIComponent implements Writeable{

    private JScrollPane scroller;
    private int columns,rows;

    public AbstractTextDisplayBox(){
        super(new JTextArea());
        this.columns = GUIConstants.TEXT_DISPLAY_DEFAULT_SIZE[0];
        this.rows = GUIConstants.TEXT_DISPLAY_DEFAULT_SIZE[1];
        this.scroller = new JScrollPane(getComponent());

        // Setting up the JTextArea -- unchangeable defaults for now unless needed later
        getComponent().setColumns(this.columns);
        getComponent().setRows(this.rows);
        getComponent().setLineWrap(true);
        getComponent().setFocusable(false);
        getComponent().setEditable(false);
    }

    //
    // Interface methods
    //
    @Override
    public final void setText(String newText) {
        getComponent().setText(newText);
        refresh();
        scrollDown();
    }

    @Override
    public final void write(String text) {
        getComponent().append(text);
        refresh();
        scrollDown();
    }

    @Override
    public final void erase(int start, int end) {
        getComponent().replaceRange("",start,end);
        refresh();
        scrollDown();
    }

    @Override
    public final void replaceText(String text, int start, int end) {
        getComponent().replaceRange(text,start,end);
        refresh();
        scrollDown();
    }

    //
    // Override methods
    //
    @Override
    protected final JTextArea getComponent(){return (JTextArea)super.getComponent();}

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
        this.getComponent().setColumns(columns);
        refresh();
        refreshScroller();
    }

    @Override
    public final void setHeight(int rows){
        this.rows = rows;
        this.getComponent().setRows(rows);
        refresh();
        refreshScroller();
    }

    //
    // Class methods
    //
    protected JScrollPane getScroller(){return this.scroller;}

    private void refreshScroller(){
        scroller.repaint();
        scroller.revalidate();
    }

    public void scrollDown(){
        JScrollBar scroller = this.scroller.getVerticalScrollBar();
        scroller.setValue(scroller.getMaximum());
        refresh();
        refreshScroller();
    }

}
