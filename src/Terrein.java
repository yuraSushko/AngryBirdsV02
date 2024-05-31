import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Terrein  {
    private ArrayList <Rectangle> pillers;
    private ArrayList <Rectangle> slingshot;
    public Terrein(){
        this.pillers = new ArrayList<>();
        this.slingshot = new ArrayList<>();
    }







    void slingshot(){
        slingshot.add(new Rectangle(Constans.SLING_SHOT_LOCATION_X,
                Constans.HIGHT-Constans.SLING_SHOT_HIGHT,
                Constans.SLING_SHOT_WIDTH,
                Constans.SLING_SHOT_HIGHT
                ));


        slingshot.add(new Rectangle(Constans.SLING_SHOT_LOCATION_X-70,
                Constans.HIGHT-Constans.SLING_SHOT_HIGHT - 20,
                70*2 + Constans.SLING_SHOT_WIDTH, 20));
        slingshot.add(new Rectangle(Constans.SLING_SHOT_LOCATION_X-70,
                Constans.HIGHT-Constans.SLING_SHOT_HIGHT - 20*3,
                20,20*3));

        slingshot.add(new Rectangle(Constans.SLING_SHOT_LOCATION_X+70*2 - 20,
                Constans.HIGHT-Constans.SLING_SHOT_HIGHT - 20*3,
                20,20*3));
    }

    void printSlingshot(Graphics g){
        g.setColor(Color.MAGENTA);
        for(Rectangle part : slingshot){
            g.fillRect(part.x, part.y, part.width,part.height);
        }
        g.setColor(Color.BLACK);
        g.drawLine(Constans.SLING_SHOT_LOCATION_X-70 +20,
                Constans.HIGHT-Constans.SLING_SHOT_HIGHT - 20*2,
                Constans.SLING_SHOT_LOCATION_X+70*2 - 20,
                Constans.HIGHT-Constans.SLING_SHOT_HIGHT - 20*2);

    }

    void randomTerreain(){
        for (int i = 0; i < 5; i++) {
            int pillerHight= random(Constans.MIN_TERRAIN_HIGHT,Constans.MAX_TERRAIN_HIGHT);
            pillers.add( new Rectangle(300+i*100,
                    Constans.HIGHT-pillerHight ,
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


}
