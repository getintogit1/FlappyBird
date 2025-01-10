
import java.awt.Image;

class Pipe{
    int pipeX;
    int Y = 0;
    int width = 64;
    int height;
    Image img;
    boolean passed = false;
    
    Pipe(Image img, int pipeX, int height){
        this.img = img;
        this.pipeX = pipeX;
        this.height = height;
    }
}
