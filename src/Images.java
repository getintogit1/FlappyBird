
import java.awt.Image;
import javax.swing.ImageIcon;

public class Images {
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    Images(String background, String bird, String topPipe, String bottomPipe){
        this.backgroundImg = new ImageIcon(getClass().getResource(background)).getImage();
        this.birdImg = new ImageIcon(getClass().getResource(bird)).getImage();
        this.topPipeImg = new ImageIcon(getClass().getResource(topPipe)).getImage();
        this.bottomPipeImg = new ImageIcon(getClass().getResource(bottomPipe)).getImage();
    }
}
