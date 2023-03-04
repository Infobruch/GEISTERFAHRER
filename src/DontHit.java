import GLOOP.*;
public class DontHit {
    GLQuader dontHit;
    GLVektor vDontHit;
    private int Px;
    private double randNum;
    public void build(){
        vDontHit = new GLVektor(125, 10, 0);
        dontHit = new GLQuader(vDontHit, 150, 20, 200);
        spawnDontHit(randPx(), Math.random() * -5000 + 2500);
    }
    private void spawnDontHit(double Px, double Pz){
        dontHit.setzePosition(Px, 10, Pz);
        dontHit.setzeFarbe(1, 0, 0);
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

        dontHit.verschiebe(0, 0, 1 * speed);
        if(dontHit.gibZ() >= 2500){
            this.changeColor(1, 0, 0);
            dontHit.setzePosition(randPx(), 10, -2500);
        }
    }
    public void changeColor(double pR, double pG, double pB){
        dontHit.setzeFarbe(pR, pG, pB);
    }
    public double getX(){
        return dontHit.gibX();
    }
    public double getY(){
        return dontHit.gibY();
    }
    public double getZ(){
        return dontHit.gibZ();
    }
}
