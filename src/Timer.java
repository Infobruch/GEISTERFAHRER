import GLOOP.*;
import java.time.LocalTime;
public class Timer {
    GLTafel timer;
    double time = 0, deltaTime = 0;

    public void build(double pX, double pY, double pZ){
        timer = new GLTafel(pX, pY, pZ, 50, 50);
        timer.setzeFarbe(0, 0, 0);
        timer.setzeTextfarbe(1, 1, 1);
        timer.setzeAutodrehung(true);
    }
    public void run(){
        if(java.time.LocalTime.now().getSecond() - deltaTime == 1 || java.time.LocalTime.now().getSecond() - deltaTime == -59){
            time++;
            timer.setzeText("Timer: " + time, 50);
        }
        deltaTime = java.time.LocalTime.now().getSecond();
    }
}
