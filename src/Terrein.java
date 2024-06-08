import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Terrein  extends JComponent {
    private ArrayList <Rectangle> pillers;
    private ArrayList <Rectangle> slingshot;
    private Rectangle restBench;
    private Rectangle bottom;
    private BufferedImage grassImg;
    public Terrein() throws IOException {
        this.pillers = new ArrayList<>();
        this.slingshot = new ArrayList<>();
        grassImg = ImageIO.read(getClass().getResource("resources/grassNew_transperent.png"));


    }



    void deleteAllPillers(){
        this.pillers.clear();
    }


    public ArrayList<Rectangle> getPillers(){
        return this.pillers;
    }

    public Rectangle getBottom(){
        return this.bottom;
    }


    void restBench(){
        this.restBench = new Rectangle(0, (int) (Constans.HIGHT_CHARACTER*1.1), (int) (Constans.WIDTH_CHARACTER*4.5),Constans.HIGHT_CHARACTER/2);
    }

    void bottom(){
        //this.bottom = new Rectangle(0,Constans.WINDOW_HIGHT-(Constans.WINDOW_INSET +Constans.HIGHT_CHARACTER/3),Constans.WINDOW_WIDTH,100);//Constans.HIGHT_CHARACTER/3
        this.bottom = new Rectangle(0,Constans.WINDOW_HIGHT-(Constans.WINDOW_INSET+Constans.HIGHT_CHARACTER/2),Constans.WINDOW_WIDTH,30);//Constans.HIGHT_CHARACTER/3


        System.out.println(this.bottom);
    }
    void printBottom(Graphics g){
        g.drawImage(grassImg,bottom.x, bottom.y, bottom.width, bottom.height,this);
    }



    void slingshot(){
        slingshot.add(new Rectangle(Constans.SLING_SHOT_LOCATION_X,
                Constans.WINDOW_HIGHT-Constans.SLING_SHOT_HIGHT,
                Constans.SLING_SHOT_WIDTH,
                Constans.SLING_SHOT_HIGHT
                ));


        slingshot.add(new Rectangle(Constans.SLING_SHOT_LOCATION_X-Constans.SLING_SHOT_ARM_LENGTH,
                Constans.WINDOW_HIGHT-Constans.SLING_SHOT_HIGHT - Constans.SLING_SHOT_ARM_WIDTH,
                Constans.SLING_SHOT_ARM_LENGTH*2 + Constans.SLING_SHOT_WIDTH, Constans.SLING_SHOT_ARM_WIDTH));

        slingshot.add(new Rectangle(Constans.SLING_SHOT_LOCATION_X-Constans.SLING_SHOT_ARM_LENGTH,
                Constans.WINDOW_HIGHT-Constans.SLING_SHOT_HIGHT - Constans.SLING_SHOT_ARM_WIDTH*3,
                Constans.SLING_SHOT_ARM_WIDTH,Constans.SLING_SHOT_ARM_WIDTH*3));

        slingshot.add(new Rectangle(Constans.SLING_SHOT_LOCATION_X+Constans.SLING_SHOT_ARM_LENGTH*2 - 20,
                Constans.WINDOW_HIGHT-Constans.SLING_SHOT_HIGHT - Constans.SLING_SHOT_ARM_WIDTH*3,
                Constans.SLING_SHOT_ARM_WIDTH,Constans.SLING_SHOT_ARM_WIDTH*3));
    }

    void printSlingshot(Graphics g){
        g.setColor(Color.MAGENTA);
        for(Rectangle part : slingshot){
            g.fillRect(part.x, part.y, part.width,part.height);
        }
        g.setColor(Color.BLACK);
        g.drawLine(Constans.SLING_SHOT_LOCATION_X-70 +20,
                Constans.WINDOW_HIGHT-Constans.SLING_SHOT_HIGHT - 20*2,
                Constans.SLING_SHOT_LOCATION_X+70*2 - 20,
                Constans.WINDOW_HIGHT-Constans.SLING_SHOT_HIGHT - 20*2);

    }

    void randomTerreain(){
        for (int i = 0; i < Constans.NUMBER_OF_PILLERS; i++) {
            int pillerHight= random(Constans.MIN_TERRAIN_HIGHT,Constans.MAX_TERRAIN_HIGHT);
            pillers.add( new Rectangle(400+i*100,
                    Constans.WINDOW_HIGHT-pillerHight ,
                    Constans.PILLER_WIDTH,pillerHight));
        }

    }
    int random(int min, int max){
        Random rnd = new Random();
        return rnd.nextInt(min, max+1);
    }

    void printPiller(Graphics g){
        g.setColor(Color.ORANGE);
        for(Rectangle piller : pillers){
            g.fillRect(piller.x, piller.y, piller.width,piller.height);
        }

    }

    void printRestBench(Graphics g ){
        g.setColor(Color.ORANGE);
        g.fillRect(this.restBench.x,this.restBench.y,this.restBench.width,this.restBench.height);
    }

}
