import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameActionListener implements MouseListener, MouseMotionListener {
    public boolean lunchBird= false;
    private int xLunch=Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_WIDTH;
    private int yLunch=Constans.HIGHT/2;
    private int xPulsPlusAmt=0; // incriment for x+= amount
    private int yPulsPlusAmt=0; // incriment for y+= amount
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
            yLunch = Constans.HIGHT/2;
            xLunch = Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_WIDTH;

    }

    public void mouseReleased(MouseEvent e) {
        System.out.println(lunchBird);
        if(e.getX()<Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_WIDTH
                && e.getY()>Constans.HIGHT/2  // slingshot hight plussome val
        ) {
           // xPulsPlusAmt = (Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_WIDTH -  e.getX()) / 10;
            xPulsPlusAmt = (Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_WIDTH -  xLunch) / 10;
            System.out.println(xPulsPlusAmt);
           // yPulsPlusAmt= (e.getY()- Constans.HIGHT/2  )/10;  /// if bird is closer to ground then y++ incriment is positive // else negative
            yPulsPlusAmt= (yLunch- Constans.HIGHT/2  )/10;
            System.out.println(yPulsPlusAmt);
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
