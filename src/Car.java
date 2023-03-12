import GLOOP.GLQuader;
import GLOOP.GLVektor;

public class Car {
    GLVektor vCarPos;
    GLQuader car;
    public void load(GLVektor vNewCarpos, double carWith, double carLength){
        vCarPos = new GLVektor(vNewCarpos);
        car = new GLQuader(vCarPos.x, vCarPos.y + 5, vCarPos.z, carWith, 10, carLength);
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
