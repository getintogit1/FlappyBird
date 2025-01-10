
import java.awt.Image;

class Bird{      
    int xPosition;
    int yPosition;
    int width = 34;
    int height =24;
    Image img;

    Bird (Image img, int xPosition, int yPosition){
        this.img = img;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

}