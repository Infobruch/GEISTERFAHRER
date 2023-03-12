import GLOOP.*;
public class GUI {
    Timer timer;
    public void load(){
        timer = new Timer();
        timer.load(0, 500, 0);
    }
    public void runTimer(){
        timer.run();
    }
}
