import GLOOP.*;

public class Game {
    GLTastatur kb;
    CamAndEnvironment camAndEnvironment;
    GLVektor vCamPos, vCamLookAt, vLightPos, vCarPos;
    Car car;
    double carSpeed = 3;
    double carWith = 80, carLength = 160;
    DontHit dontHit;
    GUI gui;
    Street street;
    double streeSpeed = 5;
    Game(){
        kb = new GLTastatur();
        vCarPos = new GLVektor(0, 5, 0);
        vCamPos = new GLVektor(vCarPos.x, vCarPos.y + 30, vCarPos.z);
        vCamLookAt = new GLVektor(vCarPos.x, vCarPos.y + 10, vCarPos.z - 100);
        vLightPos = new GLVektor(0, 2000, 2000);
        camAndEnvironment = new CamAndEnvironment();
        camAndEnvironment.load(vCamPos, vCamLookAt, vLightPos);
        car = new Car();
        car.load(vCarPos, carWith, carLength);
        dontHit = new DontHit();
        gui = new GUI();
        gui.load();
        street = new Street();
        street.load();


        this.gameLOOP();
    }
    private void gameLOOP(){
        while(!kb.alt() && !kb.enter()){
            while(!kb.esc()){
                car.updateVCarPos(vCarPosUpdate());
                //camAndEnvironment.updateCamPos(vCamPosUpdate());
                camAndEnvironment.updateLookAt(vCamLookAtUpdate());
                street.go(streeSpeed);
                Sys.warte();
            }
        }
    }
    private GLVektor vCarPosUpdate(){
        if(kb.rechts() && car.getX() < 500 - carWith/2){
            vCarPos.x = vCarPos.x + 1 * carSpeed;
        }
        if(kb.rechts() && car.getX() >= 500 - carWith/2){
            vCarPos.x = 500 - carWith/2;
        }
        if(kb.links() && car.getX() >= -500 + carWith/2){
            vCarPos.x = vCarPos.x - 1 * carSpeed;
        }
        if(kb.links() && car.getX() <= -500 + carWith/2){
            vCarPos.x = -500 + carWith/2;
        }
        return vCarPos;
    }
    private GLVektor vCamPosUpdate(){
        vCamPos.x = car.getX();
        vCamPos.y = car.getY() + 30;

        return vCamPos;
    }
    private GLVektor vCamLookAtUpdate(){
        vCamLookAt.x = car.getX();
        vCamLookAt.y = car.getY() + 10;
        return vCamLookAt;
    }
}
