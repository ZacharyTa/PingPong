public class ball {

    /*Notes
    position[0] = y position
    position[1] = x position
    */
 
    //----- Variables -------
    public static double[] positionReal = {screen.screenHeight / 2, screen.screenLength / 2};
    public static int[] positionDisplay = {(int)positionReal[0], (int)positionReal[1]};
    public static int velocity = 1;
    public static int degree = (int)(Math.random() * 180);
    public static double xVelocity; //-left +right
    public static double yVelocity; //-up +down

    //----- Functions -------

    //Returns sign number value
    public static int sign(int num) {
        try {
            return num / Math.abs(num);
        }
        catch(ArithmeticException e) {
            return 1;
        }
    }

    //Returns ball's actual y position
    public static double getRealYPosition() {
        return positionReal[0];
    }

    //Return ball's actual x position
    public static double getRealXPosition() {
        return positionReal[1];
    }

    //Return ball's displayed (rounded) y position
    public static int getDisplayedYPosition() {
        return (int)getRealYPosition();
    }

    //Return ball's displayed (rounded) column position
    public static int getDisplayedXPosition() {
        return (int)getRealXPosition();
    }
    
        //Return ball's xVelocity
    public static double getXVelocity() {
        return velocity * (Math.cos(Math.toRadians(degree)));
    }

    //Return ball's yVelocity
    public static double getYVelocity() {
        return velocity * (Math.sin(Math.toRadians(degree)));
    }

    //Checks if ball will collide with something
    public static void ballCollision(Bot[] botList) {
        int projectedYPosition = (int)(positionReal[0] + getYVelocity());;
        int projectedXPosition = (int)(positionReal[1] + getXVelocity());
        //Check top/bottom border collision
        if (projectedYPosition <= -1 || projectedYPosition >= screen.screenHeight) {
            degree = degree * -1;
            yVelocity = getYVelocity();
        }
        if (projectedXPosition <= -1 || projectedXPosition >= screen.screenLength) {
            velocity = 0;
            screen.gameOver = true;
        }

        //Check Bot collision
        for (Bot bot : botList) {
            if (projectedXPosition == bot.position[1]) {
                if (projectedYPosition >= bot.getTop() && projectedYPosition <= bot.getBottom()) {
                    degree = (180 - Math.abs(degree)) * sign(degree) + (int)(Math.random() * ((20 + 20) + 1) - 20);
                    xVelocity = getXVelocity();
                }
            }   
        }
        
    }

    //Move ball's position
    public static void ballMove() {
        positionReal[0] += getYVelocity();
        positionReal[1] += getXVelocity();

        positionDisplay[0] = (int)positionReal[0];
        positionDisplay[1] = (int)positionReal[1];
    }
}
