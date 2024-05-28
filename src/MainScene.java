import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class MainScene extends JPanel {

    private ArrayList<Character> characters;
    private ArrayList<Character> birds;
    private int counterThrown;
    private Terrein terrein;
    private GameActionListener gameActionListener;
    public MainScene (int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        this.setBackground(Color.WHITE);
        this.addCharchters();
        this.addBirds();
        this.mainGameLoop();
        this.gameActionListener = new GameActionListener();
        this.addMouseListener(gameActionListener);
        this.addMouseMotionListener(gameActionListener); // for drag
        terrein = new Terrein();
        terrein.randomTerreain();
        terrein.slingshot();
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Character c : this.characters) {
            c.drawCharacter(g);
        }
        terrein.printPiller(g);
        terrein.printSlingshot(g);
        for(Character bird : this.birds) {
            bird.drawMainCharacter(g);
        }
    }


    void mainGameLoop(){
        new Thread ( ()->{
            try {
                int cnt =1;
                while (true){
                    for(Character c : this.characters) {
                        c.gravity(cnt);
                        //c.checkCollision -> dies

                    }
                    cnt++;
                    repaint();
                    // if you make higther you can reduse speed of game
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
    public void addBirds(){
        this.birds = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            birds.add(new Character(Constans.MAX_SIZE_HIGHT_CHAR,
                                   Constans.MAX_SIZE_HIGHT_CHAR,
                                i*Constans.MAX_SIZE_HIGHT_CHAR*2 ,
                                0));
        }
    }

    public void addCharchters() {
        this.characters = new ArrayList<>();
        for (int i = 0; i < rndNum(Constans.MIN_NUM_OPP, Constans.MAX_NUM_OPP); i++) {
            characters.add(new Character(
                    rndNum(Constans.MIN_SIZE_WIDTH_CHAR, Constans.MAX_SIZE_WIDTH_CHAR)
                    , rndNum(Constans.MIN_SIZE_HIGHT_CHAR, Constans.MAX_SIZE_HIGHT_CHAR),
                     300+ i*50,50
                    ));
        }
    }

    public int rndNum(int min,int max ){
        return  new Random().nextInt(min,max+1);
    }


}
