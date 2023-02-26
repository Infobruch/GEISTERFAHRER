import GLOOP.*;
public class Car {
    GLQuader car;
    GLVektor vCarPos;
    public void build(GLVektor vNewCarpos){
        vCarPos = new GLVektor(vNewCarpos);
        car = new GLQuader(vCarPos, 50, 20, 120);
        car.setzeFarbe(1, 1, 1);
    }
    public void updateVCarPos(GLVektor vNewCarPos){
        vCarPos = vNewCarPos;
        car.setzePosition(vCarPos);
    }
    public double getX(){
        return car.gibX();
    }
    public double getY(){
        return car.gibX();
    }
    public double getZ(){
        return car.gibX();
    }
}
