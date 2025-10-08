package engine.gui;

public interface Writeable {

    void write(String text);
    void erase(int start, int end);
    void setText(String newText);
    void replaceText(String text, int start, int end);

    void slowWrite(String text);

}
