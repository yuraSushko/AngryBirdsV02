import java.awt.*;

public class Character {
    private int  sizeWidth;
    private int  sizeHight;
    private int x;
    private int y;
    private int timePartInFalling;

    public Character(int sizeWidth, int sizeHight,int x, int y) {
        this.sizeWidth = sizeWidth;
        this.sizeHight = sizeHight;
        this.x=x;
        this.y=y;
        this.timePartInFalling=0;
    }

    void gravity(int cnt){
        // if in collision with pillers then not active and set timePartInFalling=0
        // else if bottom of screen
        // else you can continue fallig
        //timePartInFalling++;
        if(this.y<=Constans.HIGHT){
            this.y+=1*cnt;
            //this.y+=1*timePartInFalling;
        }
    }





    public void drawMainCharacter( Graphics g){
        g.setColor(Color.RED);
        g.fillOval(this.x,this.y,
                Constans.OPP_CHAR_HIGHT,
                Constans.OPP_CHAR_HIGHT);
    }

    public void drawCharacter( Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(this.x,this.y,
                   Constans.OPP_CHAR_HIGHT,
                   Constans.OPP_CHAR_HIGHT);
    }

}
