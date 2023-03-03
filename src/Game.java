import GLOOP.*;
public class Game {
    Scene scene;
    Timer timer;
    DontHit[] dontHit;
    Car car;
    GLTastatur kb;
    GLVektor vCamPos, vCarPos, vCamLookAt;
    double carSpeed = 3;
    public void run(){
        dontHit = new DontHit[]{new DontHit(), new DontHit(), new DontHit(), new DontHit(), new DontHit(), new DontHit(), new DontHit(), new DontHit(), new DontHit(), new DontHit()};

        for(int i = 0; i < dontHit.length; i++){
            dontHit[i].build();
        }

        timer = new Timer();
        timer.build(0, 500, 0);
        kb = new GLTastatur();
        scene = new Scene();
        scene.build();
        car = new Car();
        vCarPos = new GLVektor(0, 10, 1000);
        car.build(vCarPos);
        vCamPos = new GLVektor(car.getX(), 500, 2000);
        vCamLookAt = new GLVektor(vCarPos);

        this.mainGameLoop();

    }
    private void mainGameLoop(){
        while(!kb.esc()){
            car.updateVCarPos(vCarPosUpdate());
            scene.changeCamPos(vCamPosUpdate());
            scene.changeCamLookAt(vCamLookAtUpdate());
            scene.go(4);
            for(int i = 0; i < dontHit.length; i++){
                dontHit[i].go(5);
            }
            this.colisionDetection();
            timer.run();
            Sys.warte();
        }
    }
    private GLVektor vCarPosUpdate(){
        if(kb.rechts() && car.getX() < 475){
            vCarPos.x = vCarPos.x + 1 * carSpeed;
        }
        if(kb.rechts() && car.getX() >= 475){
            vCarPos.x = 475;
        }
        if(kb.links() && car.getX() >= -475){
            vCarPos.x = vCarPos.x - 1 * carSpeed;
        }
        if(kb.links() && car.getX() <= -475){
            vCarPos.x = -475;
        }
        return vCarPos;
    }
    private GLVektor vCamPosUpdate(){
        vCamPos.x = vCarPos.x;
        return vCamPos;
    }
    private GLVektor vCamLookAtUpdate(){
        vCamLookAt = vCarPos;
        return vCamLookAt;
    }
    private void colisionDetection(){
        for(int i = 0; i < dontHit.length; i++){
            if((((car.getX() + 25 >= dontHit[i].getX() + 75) && (car.getX() - 25 <= dontHit[i].getX() + 75)) || ((car.getX() + 25 >= dontHit[i].getX() - 75) && (car.getX() - 25 <= dontHit[i].getX() - 75))) && (((car.getZ() + 60 >= dontHit[i].getZ() + 100) && (car.getZ() - 60 <= dontHit[i].getZ() + 100)) || ((car.getZ() + 60 >= dontHit[i].getZ() - 100) && (car.getZ() - 60 <= dontHit[i].getZ() - 100)))){
                System.out.println("hit");
            }
        }
    }

}
