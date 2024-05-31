import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameActionListener implements MouseListener, MouseMotionListener, ActionListener {
    public boolean lunchBird= false;
    private int xLunch=Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_WIDTH;
    private int yLunch=Constans.HIGHT/2;
    private int xPulsPlusAmt=0; // incriment for x+= amount
    private int yPulsPlusAmt=0; // incriment for y+= amount
    private ArrayList<Bird> birds;
    boolean canPutBirdInLunchPad=true;
    boolean birdInLuchPad= false;
    private Bird currBird;


    public GameActionListener(ArrayList<Bird> birds){
        this.birds=birds;
    }

    public void actionPerformed(ActionEvent e) {
        Window.latestClicked=(JButton) e.getSource();
    }
    public int getxPulsPlusAmt(){
        return this.xPulsPlusAmt;
    }

    public int getyPulsPlusAmt(){
        return this.yPulsPlusAmt;
    }


    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
            yLunch = Constans.HIGHT/2;
            xLunch = Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_WIDTH;
            int count=0;
            for(Bird b : birds) {
                if (b.getCharacterAsRectangle().contains(70+40, 300)){count++;}
            }
            if(count==0){canPutBirdInLunchPad=true;}
            for(Bird b : birds) {
                if (b.getCharacterAsRectangle().contains(e.getPoint()) && e.getX() < 200 && e.getY() < 100) {
                    System.out.println("in range for chosing");
                    if(canPutBirdInLunchPad) {
                        b.setLocation(70 + 40, 300);
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
                && e.getY()>Constans.HIGHT/2  // slingshot hight plussome val
        ) {
            xPulsPlusAmt = (Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_WIDTH -  xLunch) / 10;
            System.out.println(xPulsPlusAmt);
            yPulsPlusAmt= ( Constans.HIGHT/2-yLunch  )/10;
            System.out.println(yPulsPlusAmt);
            if(currBird!=null){
                currBird.moveUp(yPulsPlusAmt);
                currBird.moveRight(xPulsPlusAmt);
            }



        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        System.out.println("dragging");
        System.out.println(lunchBird);
        if(e.getX()<Constans.SLING_SHOT_WIDTH+Constans.SLING_SHOT_WIDTH
                && e.getY()>Constans.HIGHT/2  // slingshot hight plussome val
        ) {
            yLunch = e.getY();
            xLunch = e.getX();
        }
    }

    public void mouseMoved(MouseEvent e) {

    }
}
