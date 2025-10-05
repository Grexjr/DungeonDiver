package engine.gui;

public class DefaultScreen extends AbstractScreen{

    protected DefaultScreen(){
        this.init();
    }

    @Override
    public void onCreate(){
        this.show();
        System.out.println("Created!");
    }

    @Override
    public void onDestroy(){
        System.out.println("Destroyed!");
    }

}
