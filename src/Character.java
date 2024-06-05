import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Character extends JComponent {
    private int sizeWidth;
    private int sizeHight;
    private int x;
    private int y;
    private int timePartInFalling;
    private BufferedImage regualrBirdImapge;

    public Character(int sizeWidth, int sizeHight,int x, int y, String imagePath) {
        this.sizeWidth = sizeWidth;
        this.sizeHight = sizeHight;
        this.x=x;
        this.y=y;
        this.timePartInFalling=0;
        //regualrBirdImapge= new ImageIcon("resources/angryBirdsOpeneing.jpg"/*resources/angryBirdsMainBirdPic.png"*/).getImage();
        try {
            regualrBirdImapge =ImageIO.read(getClass().getResource(imagePath /*"resources/angryBirdsMainBirdPic_transperent.png"*/));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void gravity(){
        // if in collision with pillers then not active and set timePartInFalling=0
        // else if bottom of screen
        // else you can continue fallig
        //timePartInFalling++;
        if(this.x>Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_WIDTH){
            if(this.y<=Constans.HIGHT - this.sizeHight*4) {
                if(!collisionWithPiller()) {
                    this.y += 0.1 * timePartInFalling;
                    timePartInFalling++;
                }else{timePartInFalling=0;}
            }

        }
    }


    public boolean withinBounds(){
        boolean within = false;
        if(this.x>= 0 - Constans.WIDTH_CHARACTER*4 && this.x<=Constans.WIDTH){
            if(this.y>=0-Constans.HIGHT_CHARACTER*4 && this.y<=Constans.WIDTH-Constans.HIGHT_CHARACTER){
                within=true;
            }
        }
        return within;
    }

    public boolean collisionWithPiller(){
        boolean collision = false;
        for(Rectangle piller : MainScene.terrein.getPillers() ) {
            if (this.getCharacterAsRectangle().intersects(piller)) {
                collision = true;
                break;
            }
        }
        return collision;
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


    public void drawCharacter( Graphics g ){
        g.drawImage(regualrBirdImapge, x, y, sizeWidth, sizeHight, this);
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

    @Override
    public String toString() {
        return "Character{" +
                "sizeWidth=" + sizeWidth +
                ", sizeHight=" + sizeHight +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
