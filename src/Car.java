import GLOOP.*;

import java.io.File;

public class Car {
    Model car;
    GLVektor vCarPos;
    public void build(GLVektor vNewCarpos, double carWith, double carLength){
        vCarPos = new GLVektor(vNewCarpos);
        car = new Model(vCarPos.x, vCarPos.y, vCarPos.z, carWith, 1, carLength, new File("src/AUTO.stl"));
        car.skaliere(80);
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
        return car.gibY();
    }
    public double getZ(){
        return car.gibZ();
    }
    public GLVektor getvCarPos(){
        return vCarPos;
    }
}
