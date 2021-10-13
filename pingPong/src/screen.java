/*
Problem: Cant detech keystrokes within console without a GUI
*/

public class screen {

    static int screenLength = 139;
    static int screenHeight = 14;
    static char[][] screenDisplay = new char[screenHeight][screenLength];

    public static boolean gameOver = false;

    //Pauses program in milliseconds
    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    //Fills 2D Array with space characters (so it isnt filled with null variables)
    public static void screenFillSpace() {
        for (int row = 0; row < screenHeight; row++) {
            for (int column = 0; column < screenLength; column++) {
                screenDisplay[row][column] = ' ';
            }
        }
    }

    //Places bots into screen's 2D array
    public static void screenFillBots(Bot[] botList) {
        for (Bot bot : botList) {
            for (int i = 0; i < bot.size; i++) {
                screenDisplay[bot.getTop() + i][bot.position[1]] = 'X';
            }
        }
    }

    //Places ball into screen's 2D array
    public static void screenFillBall() {
        screenDisplay[ball.getDisplayedYPosition()][ball.getDisplayedXPosition()] = 'O';
    }

    //Places "Game Over Text" onto screen's 2D array
    public static void gameOverScreen() {
        String gameOverText = "G A M E   O V E R";
        for (int c = 0; c < gameOverText.length(); c++) {
            screenDisplay[screen.screenHeight / 2][(screen.screenLength / 2) - (gameOverText.length() / 2) + c] = gameOverText.charAt(c);
        }
    }

    //Prevents unwanted object appearances by printing a blank screen before projecting objects
    public static void screenClear() {
        for (int row = 0; row < screenHeight; row++) {
            System.out.println();
        }
        pause(1);
    }

    //Projects screen by printing each of the 2D array's index
    public static void project() {
        for (int row = 0; row < screenHeight; row++) {
            for (int column = 0; column < screenLength; column++) {
                System.out.print(screenDisplay[row][column]);
                }
            System.out.println();
            }
        }
    
    // ----------- Main ----------------
    public static void main(String[] args) {

        Bot zachary, terralyn;
        zachary = new smartBot();
        terralyn = new dumbBot();
        Bot[] bots = {zachary, terralyn};

        while (gameOver == false){
            screenFillSpace();

            zachary.position[0] = smartBot.followBall(ball.getDisplayedYPosition(), zachary);
            terralyn.position[0] = dumbBot.actsDumb(terralyn);

            ball.ballCollision(bots);
            ball.ballMove();

            screenFillBall();
            screenFillBots(bots);

            screenClear();
            project();

            pause(25);
            screenClear();
        }
        gameOverScreen();
        project();

    }
}
