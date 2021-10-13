public class Bot {
   
    protected int size;
    protected int[] position;

    Bot(int[] inputPosition, int inputSize) {
        this.size = inputSize;
        this.position = inputPosition;
    }

    //Returns position of the Bot's top
    public int getTop() {
        return position[0] - (size - 1) / 2;
    }

    //Returns position of the Bot's bottom
    public int getBottom() {
        return position[0] + (size - 1) / 2;
    }

    //Moves Bot
    public int move(String direction, Bot bot) {
        switch (direction) {
            case "up":
                if (bot.position[0] - (bot.size - 1) / 2 > 0) {
                    return bot.position[0] -= 1; }
                break;
            
            case "down":
                if (bot.position[0] + (bot.size - 1) / 2 < screen.screenHeight - 1) {
                    return bot.position[0] += 1; }
                break;

            default:
                return bot.position[0];
        }
        return bot.position[0];
    }
}
