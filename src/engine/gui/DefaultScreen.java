package engine.gui;

public class DefaultScreen extends AbstractScreen{

    protected DefaultScreen(){
        this.init();
    }

    @Override
    public void onCreate(){;
        System.out.println("Default Screen created!");
    }

    @Override
    public void onDestroy(){
        System.out.println("Default screen destroyed!");
    }

}
