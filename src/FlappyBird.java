import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;


public class FlappyBird extends JPanel implements ActionListener, KeyListener{
    Constants constants;
    Images images;
    Bird bird;
    Timer gameLoop;
    Timer placePipeTimer;
    ArrayList<Pipe> pipes;
    Random random = new Random();
    GameState gameState;
    PipeManager pipeManager;

    FlappyBird(){
        constants = new Constants(360, 640,512, 0, -4, 0, 1 ) ;
        gameState = new GameState();
        setPreferredSize(new Dimension(constants.boardWidth, constants.boardHeight));
        setFocusable(true);                                           // flappybid class is teh class that going to handle our key events 
        addKeyListener(this);                                                              
        images = new Images("images/flappybirdbg.png", "images/flappybird.png", "images/toppipe.png","images/bottompipe.png" );
        bird = new Bird(images.birdImg, (int)constants.boardWidth/2, (int) constants.boardHeight/2);
        pipes = new ArrayList<Pipe>();
        pipeManager = new PipeManager(images, constants, gameState);
        placePipeTimer = new Timer(constants.PIPE_TIMER_DELAY, placePipesListener);
        placePipeTimer.start();
        gameLoop = new Timer(constants.GAME_LOOP_DELAY, this);
        gameLoop.start();
    }

    ActionListener placePipesListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            pipeManager.placePipes();
        }
    };

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        g.drawImage(images.backgroundImg, 0,0,constants.boardWidth, constants.boardHeight, null); 
        g.drawImage(bird.img, bird.xPosition, bird.yPosition ,bird.width, bird.height, null); 
        for (Pipe pipe : pipeManager.getPipes()) {
            g.drawImage(pipe.img, pipe.pipeX, pipe.Y, pipe.width, pipe.height, null);
        }
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 32));
        if(gameState.gameOver){
            g.drawString ("Game Over:" + String.valueOf((int)gameState.score),10, 35);
        }else{
            g.drawString(String.valueOf((int) gameState.score), 10, 35);
        }
    }

    public boolean collison ( Bird bird , Pipe pipe){
        return bird.xPosition < pipe.pipeX + pipe.width && 
               bird.xPosition + bird.width > pipe.pipeX &&
               bird.yPosition < pipe.Y + pipe.height    && 
               bird.yPosition + bird.height > pipe.Y;
    }

    private void moveBird(){
        constants.velocityY += constants.gravity;
        bird.yPosition += constants.velocityY;   
        // not allowing to pass top boundarie of frame
        bird.yPosition = Math.max(bird.yPosition, 0);
   
    }

    private void checkGameOver(){
        if (bird.yPosition > constants.boardHeight){
            gameState.gameOver = true;
        }

        if (gameState.gameOver){
            placePipeTimer.stop();
            gameLoop.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveBird();
        pipeManager.movePipes(bird);
        repaint();
        checkGameOver();                                                            // will call paint method     
    }

    @Override
    public void keyPressed(KeyEvent e) {
        boolean spaceKeyPressed = e.getKeyCode() == KeyEvent.VK_SPACE;
       if (spaceKeyPressed){
        constants.velocityY = constants.JUMP_VELOCITY;
            System.out.println(gameState.gameOver);
            if(gameState.gameOver){
                bird.yPosition = constants.boardHeight/2;
                constants.velocityY = 0;
                pipeManager = new PipeManager(images, constants, gameState);
                gameState.score = 0;
                gameState.gameOver = false;
                gameLoop.start();
                placePipeTimer.start();
            }
       }  
    }

    @Override
    public void keyTyped(KeyEvent e) { 
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

