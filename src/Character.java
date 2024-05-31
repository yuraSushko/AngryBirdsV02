import java.awt.*;

public class Character {
    private int sizeWidth;
    private int sizeHight;
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
        if(this.x>Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_WIDTH){
            this.y+=0.1 *cnt;
            //this.y+=1*timePartInFalling;
        }
    }



    Rectangle getCharacterAsRectangle(){
        return new Rectangle(this.x,this.y,this.sizeWidth,this.sizeHight);

    }



    public void setLocation(int x, int y){
        this.x=x;
        this.y=y;
    }


    public void moveUp(int amount){
        this.y+=amount;
    }
    public void moveRight(int amount){
        this.x+=amount;
    }


    public void drawCharacter( Graphics g , Color color){
        g.setColor(color);
        /* g.fillOval(this.x,this.y,
                Constans.OPP_CHAR_HIGHT,
                Constans.OPP_CHAR_HIGHT);*/
        g.fillRect(this.x,this.y,
                Constans.OPP_CHAR_HIGHT,
                Constans.OPP_CHAR_HIGHT);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /*
    public void drawCharacter( Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(this.x,this.y,
                   Constans.OPP_CHAR_HIGHT,
                   Constans.OPP_CHAR_HIGHT);
    }*/

}
