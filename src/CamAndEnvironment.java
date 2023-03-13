import GLOOP.*;
public class CamAndEnvironment {
    GLKamera cam;
    GLLicht light;
    public void load(GLVektor pCamP, GLVektor pLookAtP, GLVektor pLightP){
        cam = new GLEntwicklerkamera(1200, 1440);
        cam.setzePosition(pCamP);
        cam.setzeBlickpunkt(pLookAtP);
        light = new GLLicht(pLightP);
    }
    public void updateCamPos(GLVektor pCampos){
        cam.setzePosition(pCampos);
    }
    public void updateLookAt(GLVektor pLookAt){
        cam.setzePosition(pLookAt);
    }
}