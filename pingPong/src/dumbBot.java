public class dumbBot extends Bot {
    
    dumbBot() {
        super(new int[]{screen.screenHeight / 2, screen.screenLength - 3}, 5);
    }

    //Acts dumb (randomnly moves)
    public static int actsDumb(Bot bot){
        int num = (int)(Math.random() * ((5 - 1) + 1) + 1);
            if (num == 1) {
                return bot.move("up", bot);
            }
            else if (num == 2) {
                return bot.move("down", bot);
            }
            
            else {
                return bot.position[0];
            }
    }
}
