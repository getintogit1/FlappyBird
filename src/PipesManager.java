
import java.util.ArrayList;

class PipeManager {
    private ArrayList<Pipe> pipes;
    private Images images;
    private Constants constants;
    private GameState gameState;

    PipeManager(Images images, Constants constants, GameState gameState) {
        this.images = images;
        this.constants = constants;
        this.pipes = new ArrayList<>();
        this.gameState = gameState;
    }

    public void placePipes(){
        int numberTo256 = (int) (Math.random() * (constants.pipeHeight/2));
        int randomPipeY = (constants.pipeY - constants.pipeHeight/4) - numberTo256; 
        int openingSpace = constants.boardHeight/4;
    
        Pipe topPipe = new Pipe(images.topPipeImg, constants.boardWidth, constants.pipeHeight);
        topPipe.Y = randomPipeY;
        this.pipes.add(topPipe);
        Pipe bottomPipe = new Pipe(images.bottomPipeImg, constants.boardWidth, constants.boardHeight);
        bottomPipe.Y = topPipe.Y + constants.pipeHeight + openingSpace;
        this.pipes.add(bottomPipe);
        
        while (pipes.size() > 4) {
        pipes.remove(0); 
        }
    }

    public void movePipes(Bird bird){
        for(int i=0; i < this.pipes.size(); i++){
             Pipe pipe = this.pipes.get(i);
             pipe.pipeX += constants.velocityX;
             
             if(!pipe.passed && bird.xPosition > pipe.pipeX + pipe.width){
                gameState.score += 0.5;
                pipe.passed = true;
             }

             if(collison(bird, pipe)){
                gameState.gameOver = true;
             }
        }

    }

    public boolean collison ( Bird bird , Pipe pipe){
        return bird.xPosition < pipe.pipeX + pipe.width && 
               bird.xPosition + bird.width > pipe.pipeX &&
               bird.yPosition < pipe.Y + pipe.height    && 
               bird.yPosition + bird.height > pipe.Y;
    }

    public ArrayList<Pipe> getPipes() {
        return this.pipes;
    }
    
}