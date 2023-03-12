import GLOOP.*;

public class Game {
    CamAndEnvironment camAndEnvironment;
    GLVektor vCamAndEnvironment;
    Car car;
    DontHit dontHit;
    GUI gui;
    Street street;
    Game(){
        camAndEnvironment = new CamAndEnvironment();
        camAndEnvironment.load();
        car = new Car();
        dontHit = new DontHit();
        gui = new GUI();
        street = new Street();

    }
}
