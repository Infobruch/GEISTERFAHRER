import GLOOP.*;
public class Game {
    Scene scene;
    Timer timer;
    DontHit[] dontHit;
    Car car;
    double carWith = 80;
    double carLength = 80;
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
        car.build(vCarPos, carWith, carLength);
        vCamPos = new GLVektor(car.getX() + 180, 2000, 1000);
        vCamLookAt = new GLVektor(car.getX(), car.getY() + 500, car.getZ() - 2000);

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
        if(kb.rechts() && car.getX() < 500 - carWith){
            vCarPos.x = vCarPos.x + 1 * carSpeed;
        }
        if(kb.rechts() && car.getX() >= 500 - carWith){
            vCarPos.x = 500 - carWith;
        }
        if(kb.links() && car.getX() >= -500 + carWith){
            vCarPos.x = vCarPos.x - 1 * carSpeed;
        }
        if(kb.links() && car.getX() <= -500 + carWith){
            vCarPos.x = -500 + carWith;
        }
        return vCarPos;
    }
    private GLVektor vCamPosUpdate(){
        vCamPos.x = vCarPos.x;
        return vCamPos;
    }
    private GLVektor vCamLookAtUpdate(){
        vCamLookAt.x = car.getX();
        vCamLookAt.z = car.getZ();
        return vCamLookAt;
    }
    private void colisionDetection(){
        for(int i = 0; i < dontHit.length; i++){
            if(Math.sqrt(Math.pow(dontHit[i].getX() - car.getX(), 2) + Math.pow(dontHit[i].getZ() - car.getZ(), 2)) < carWith + 75 && (dontHit[i].getZ() - car.getZ() < carLength + 100)){
                System.out.println("hit" + Math.sqrt(Math.pow(dontHit[i].getX() - car.getX(), 2) + Math.pow(dontHit[i].getZ() - car.getZ(), 2)));
                System.out.println(car.getZ() + "   " + dontHit[i].getZ());
                dontHit[i].changeColor(0, 0, 1);
                //Sys.warte(1000);

            }
            System.out.println(Math.sqrt(Math.pow(dontHit[i].getX() - car.getX(), 2) + Math.pow(dontHit[i].getZ() - car.getZ(), 2)));
        }
    }
}