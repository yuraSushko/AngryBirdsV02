import java.awt.event.*;
import java.util.ArrayList;

public class GameActionListener implements MouseListener, MouseMotionListener {
    public boolean lunchBird= false;
    private int xLunch=Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_WIDTH;
    private int yLunch=Constans.WINDOW_HIGHT/2;
    private int xPulsPlusAmt=0; // incriment for x+= amount
    private int yPulsPlusAmt=0; // incriment for y+= amount
    private ArrayList</*Bird*/Character> birds;
    boolean canPutBirdInLunchPad=true;
    boolean birdInLuchPad= false;
    private /*Bird*/ Character currBird;


    public GameActionListener(ArrayList</*Bird*/Character> birds){
        this.birds=birds;  //TODO change to static becaues fluid
    }


/*    public int getxPulsPlusAmt(){
        return this.xPulsPlusAmt;
    }
    public int getyPulsPlusAmt(){
        return this.yPulsPlusAmt;
    }*/



    public void mousePressed(MouseEvent e) {
            yLunch = Constans.WINDOW_HIGHT-(Constans.SLING_SHOT_HIGHT+Constans.HIGHT_CHARACTER) ;  //Constans.WINDOW_HIGHT/2;
            xLunch = Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_WIDTH/2 - Constans.WIDTH_CHARACTER/2;
            int count=0;
            for(/*Bird*/ Character b : birds) {
                if (b.getCharacterAsRectangle().contains(70+40, 300)){count++;}
            }
            if(count==0){canPutBirdInLunchPad=true;}
            for(/*Bird*/ Character b : birds) {
                if (b.getCharacterAsRectangle().contains(e.getPoint()) && e.getX() < 200 && e.getY() < 100) {
                    System.out.println("in range for chosing");
                    if(canPutBirdInLunchPad) {
                        b.setLocation(xLunch, yLunch);
                        currBird=b;
                        System.out.println("location was set");
                        canPutBirdInLunchPad=false;
                        birdInLuchPad=true;
                    }
                }
            }
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println(lunchBird);
        if(e.getX()<Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_WIDTH
                && e.getY()>Constans.WINDOW_HIGHT/2  // slingshot hight plussome val
        ) {
            xPulsPlusAmt = (Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_WIDTH -  xLunch) / 10;
            System.out.println(xPulsPlusAmt);
            yPulsPlusAmt= ( Constans.WINDOW_HIGHT/2-yLunch  )/10;
            System.out.println(yPulsPlusAmt);
            if(currBird!=null){
                int cnt=0;
                System.out.println(currBird.withinBounds()+ "within bounds");
                System.out.println(!currBird.collisionWithPiller() + "not colssion ");
                //TODO action not printing on screen because not in Thered
                currBird.setMoveRightIncremet(xPulsPlusAmt);
                currBird.setMoveUpIncremet(yPulsPlusAmt);
                /*


                while ( currBird.withinBounds() && !currBird.collisionWithPiller()) {
                    System.out.println("moving");
                    currBird.moveUp(yPulsPlusAmt);
                    currBird.moveRight(xPulsPlusAmt);
                    cnt++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }*/
            }

        }
    }


    public void mouseDragged(MouseEvent e) {
        System.out.println("dragging");
        System.out.println(lunchBird);
        if(e.getX()<Constans.SLING_SHOT_WIDTH+Constans.SLING_SHOT_WIDTH
                && e.getY()>Constans.WINDOW_HIGHT/2  // slingshot hight plussome val
        ) {
            yLunch = e.getY();
            xLunch = e.getX();
        }
    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }
}
