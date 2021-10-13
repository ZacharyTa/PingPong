public class smartBot extends Bot {

    smartBot() {
        super(new int[]{screen.screenHeight / 2, 3}, 3);
    }

    //Follows ball
    public static int followBall(int ballYPosition, Bot bot) {
        if (ballYPosition > bot.position[0]) {
            return bot.move("down", bot);
        }

        else if (ballYPosition < bot.position[0]) {
            return bot.move("up", bot);
        }
        return bot.position[0];
    }
}