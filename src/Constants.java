public class Constants {
      int boardWidth = 360;
      int boardHeight = 640;
      int pipeHeight = 512;
      int pipeY = 0;
      int velocityX = -4;
      int velocityY = 0;                                                                                              // move pipes to the left speed ( simulating  bird is moving to the right)
      int gravity = 1;
      final int PIPE_TIMER_DELAY;
      final int GAME_LOOP_DELAY;
      final int JUMP_VELOCITY;


    Constants(int boardWidth, int boadrdHeight, int pipeHeight, int pipeY,
              int velocityX, int velocityY, int gravity){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.pipeHeight = pipeHeight;
        this.pipeY = pipeY;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.gravity = gravity;

        this.PIPE_TIMER_DELAY = 1500;
        this.GAME_LOOP_DELAY = 1000 / 60;
        this.JUMP_VELOCITY = -9;
      }
}
