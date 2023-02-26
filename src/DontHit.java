import GLOOP.*;
public class DontHit {
    GLQuader[] dontHit;
    GLVektor vDontHit;
    private int Px;
    private double randNum;
    public void build(){
        vDontHit = new GLVektor(125, 10, 0);
        dontHit = new GLQuader[]{new GLQuader(vDontHit, 150, 20, 200), new GLQuader(vDontHit, 150, 20, 200), new GLQuader(vDontHit, 150, 20, 200), new GLQuader(vDontHit, 150, 20, 200), new GLQuader(vDontHit, 150, 20, 200), new GLQuader(vDontHit, 150, 20, 200), new GLQuader(vDontHit, 150, 20, 200), new GLQuader(vDontHit, 150, 20, 200), new GLQuader(vDontHit, 150, 20, 200), new GLQuader(vDontHit, 150, 20, 200)};
        for(int i = 0; i < dontHit.length; i++){
            spawnDontHit(i, randPx(), Math.random() * -5000 + 2500);
        }
    }
    private void spawnDontHit(int i, double Px, double Pz){
        dontHit[i].setzePosition(Px, 10, Pz);
        dontHit[i].setzeFarbe(1, 0, 0);
    }
    private int randPx(){
        randNum = Math.random() - 0.5;
        if(randNum > 0.25){
            Px = 375;
        }
        if(randNum > 0 && randNum <= 0.25){
            Px = 125;
        }
        if(randNum < 0 && randNum >= -0.25){
            Px = -125;
        }
        if(randNum < -0.25){
            Px = -375;
        }
        return Px;
    }
    public void go(double speed){
        for(int i = 0; i < dontHit.length; i++){
            dontHit[i].verschiebe(0, 0, 1 * speed);
            if(dontHit[i].gibZ() >= 2500){
                dontHit[i].setzePosition(randPx(), 10, -2500);
            }
        }
    }
}
