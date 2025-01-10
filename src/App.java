import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        int boardWidth = 360; 
        int boadrdHeight = 640;

        JFrame frame = new JFrame("Flappy Bird");
        frame.setSize(boardWidth, boadrdHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    
        FlappyBird flappyBird = new FlappyBird();
        frame.add(flappyBird);
        frame.pack();     
        flappyBird.requestFocus();                                                      // heigth x width excluding title bar
        frame.setVisible(true);

    }
}
