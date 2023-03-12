import GLOOP.*;
public class CamAndEnvironment {
    GLKamera cam;
    GLLicht light;
    public void load(GLVektor vCamP, GLVektor vLookAtP, GLVektor vLightP){
        cam = new GLKamera(1200, 1440);
        cam.setzePosition(vCamP);
        cam.setzeBlickpunkt(vLookAtP);
        light = new GLLicht(vLightP);
    }
}