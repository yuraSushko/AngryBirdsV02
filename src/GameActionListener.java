import java.awt.event.*;
import java.util.ArrayList;

public class GameActionListener implements MouseListener, MouseMotionListener {
    public boolean lunchBird= false;
    private int xLocationRealsedBird;//=Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_WIDTH/2 - Constans.WIDTH_CHARACTER/2;
    private int yLocationRealsedBird;//=Constans.WINDOW_HIGHT-(Constans.SLING_SHOT_HIGHT+Constans.HIGHT_CHARACTER);
    private int xPulsPlusAmt=0; // incriment for x+= amount
    private int yPulsPlusAmt=0; // incriment for y+= amount
    private ArrayList<Character> birds;
    private Character currBird;
    private boolean birdCilkedAtSlig;


    public GameActionListener(){
        //this.birds=birds;  //TODO change to static becaues fluid
    }

    public Character getCurrBird(){
        return this.currBird;
    }

    public void setBirdsList(ArrayList<Character> birds){
        this.birds=birds;
    }
    public void removeOneBird(Character bird){
        if(bird!=null) {
            this.currBird = null;
            //this.birds.remove(bird);
            this.birds.remove(currBird);
            // TODO remove currBird insted
        }

    }


    public void mousePressed(MouseEvent e) {


         yLocationRealsedBird =0;
         xLocationRealsedBird =0;
         int countBirdsOnSling=0;
         for(Character b : birds) {
                System.out.println(b);
                if (b.getCharacterAsRectangle().contains(Constans.PUT_BIRD_ON_SLIG_X, Constans.PUT_BIRD_ON_SLIG_Y)){
                    countBirdsOnSling++; break;
                }
            }
         for( Character b : birds) {
                if (b.getCharacterAsRectangle().contains(e.getPoint())
                        && e.getX() <= Constans.REST_BENCH_WIDTH && e.getY() <=Constans.REST_BENCH_HIGHT) {
                    System.out.println("in range for chosing");
                    if(countBirdsOnSling==0 && this.currBird==null) {
                        b.setLocation(Constans.PUT_BIRD_ON_SLIG_X, Constans.PUT_BIRD_ON_SLIG_Y);
                        currBird=b;
                        System.out.println("location was set");
                    }
                }
         }
         if(currBird!=null  && currBird.getCharacterAsRectangle().contains(e.getPoint())){
             birdCilkedAtSlig=true;
         }
         else{birdCilkedAtSlig=false;}
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println(lunchBird);
        if(xLocationRealsedBird!=0 || yLocationRealsedBird!=0){
            if(e.getX()<Constans.SLING_SHOT_LOCATION_X){
            xPulsPlusAmt = (Constans.SLING_SHOT_LOCATION_X + Constans.SLING_SHOT_WIDTH - xLocationRealsedBird) / 10;
            System.out.println(xPulsPlusAmt);
            yPulsPlusAmt = (Constans.WINDOW_HIGHT / 2 - yLocationRealsedBird) / 10;
            System.out.println(yPulsPlusAmt);
            if (currBird != null) {
                System.out.println(currBird.withinBounds() + "within bounds");
                System.out.println(!currBird.collisionWithPiller() + "not colssion ");
                currBird.setMoveRightIncremet(xPulsPlusAmt);
                currBird.setMoveUpIncremet(yPulsPlusAmt);

            }
        }
        }
    }


    public void mouseDragged(MouseEvent e) {

         if(e.getX()<Constans.SLING_SHOT_LOCATION_X &&birdCilkedAtSlig){
            yLocationRealsedBird = e.getY();
            xLocationRealsedBird = e.getX();
            currBird.setLocation(xLocationRealsedBird,yLocationRealsedBird);
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
