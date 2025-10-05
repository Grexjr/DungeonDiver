package engine.gui;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractPanel extends AbstractScreen implements InputListener {

    public void addComponent(JComponent component, Object constraints){
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

        //this.getContainerPanel().add(component.getComponent(),constraints);
        refresh();
    }


}
