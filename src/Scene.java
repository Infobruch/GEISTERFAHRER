import GLOOP.*;
public class Scene {
    GLKamera cam;
    GLLicht light;
    GLTafel road;
    GLQuader[] guideLine1, guideLine2, guideLine3;
    GLQuader leftBorderLane, rightBorderLane;
    double guideLineZpos = -2500;
    public void build(){
        cam = new GLEntwicklerkamera(1200, 1440);
        cam.setzePosition(0, 750, 2000);
        cam.setzeBlickpunkt(0, 100, 0);
        light = new GLLicht();
        road = new GLTafel(0, 0, 0, 1000, 5000);
        road.drehe(90, 0, 0);
        road.setzeFarbe(0.0104166666666667, 0.0104166666666667, 0.0104166666666667);
        guideLine1 = new GLQuader[]{new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100)};
        guideLine2 = new GLQuader[]{new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100)};
        guideLine3 = new GLQuader[]{new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100), new GLQuader(0, 0, 0, 10, 5, 100)};
        System.out.println(guideLine1.length);
        for(int i = 0; i < guideLine1.length; i++){
            defineGuideLines(i, guideLineZpos);
            guideLineZpos = guideLineZpos + 200;
        }
        leftBorderLane = new GLQuader(-495, 5, 0, 10, 5, 5000);
        leftBorderLane.setzeFarbe(1, 1, 1);
        rightBorderLane = new GLQuader(495, 5, 0, 10, 5, 5000);
        rightBorderLane.setzeFarbe(1, 1, 1);
    }
    public void changeCamPos(GLVektor vCamPos){
        cam.setzePosition(vCamPos);
    }
    public void changeCamLookAt(GLVektor vCamLookAt){
        cam.setzeBlickpunkt(vCamLookAt);
    }
    private void defineGuideLines(int i, double Pz){
        guideLine1[i].setzePosition(250, 5, guideLineZpos);
        guideLine1[i].setzeFarbe(1, 1, 1);
        guideLine2[i].setzePosition(0, 5, guideLineZpos);
        guideLine2[i].setzeFarbe(1, 1, 1);
        guideLine3[i].setzePosition(-250, 5, guideLineZpos);
        guideLine3[i].setzeFarbe(1, 1, 1);
    }
    public void go(double speed){
        for(int i = 0; i < guideLine1.length; i++){
            if(guideLine1[i].gibZ() >= 2500){
                guideLine1[i].setzePosition(250, 5, -2500);
            }
            else{
                guideLine1[i].verschiebe(0, 0, 1 * speed);
            }
            if(guideLine2[i].gibZ() >= 2500){
                guideLine2[i].setzePosition(0, 5, -2500);
            }
            else{
                guideLine2[i].verschiebe(0, 0, 1 * speed);
            }
            if(guideLine3[i].gibZ() >= 2500){
                guideLine3[i].setzePosition(-250, 5, -2500);
            }
            else{
                guideLine3[i].verschiebe(0, 0, 1 * speed);
            }
        }
    }
}
