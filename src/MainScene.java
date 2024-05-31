import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class MainScene extends JPanel {

    private ArrayList<Pig> characters;
    private ArrayList<Bird> birds;
    private int counterThrown;
    private Terrein terrein;
    private GameActionListener gameActionListener;
    private Image backroundMainGame;
    public MainScene (int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        this.setLayout(null);
        //this.setBackground(Color.WHITE);
        this.backroundMainGame = new ImageIcon(getClass().getResource("resources/angryBirdsGrassImages.png")).getImage();
        this.addCharchters();
        this.addBirds();
        this.mainGameLoop();

        this.gameActionListener = new GameActionListener(birds);
        this.addMouseListener(gameActionListener);
        this.addMouseMotionListener(gameActionListener); // for drag
        terrein = new Terrein();
        terrein.randomTerreain();
        terrein.slingshot();


    }

    public ArrayList<Pig> getCharacters() {
        return characters;
    }

    public ArrayList<Bird> getBirds() {
        return birds;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.backroundMainGame,0,0,Constans.WIDTH,Constans.HIGHT,this);

        for(Pig c : this.characters) {
            c.drawCharacter(g, Color.GREEN);
        }
        terrein.printPiller(g);
        terrein.printSlingshot(g);
        for(Bird bird : this.birds) {
            bird.drawCharacter(g, Color.RED);
        }

    }


    void mainGameLoop(){
        new Thread ( ()->{
            try {
                int cnt =1;
                while (true){
                    for(Character c : this.characters) {
                        //c.checkCollision -> dies or stas in palace if on piller
                        c.gravity(cnt);
                    }
                    cnt++;
                    repaint();
                    // if you make higther you can reduse speed of game
                    Thread.sleep(20);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
    public void addBirds(){
        this.birds = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            birds.add(new Bird(Constans.MAX_SIZE_HIGHT_CHAR,
                                   Constans.MAX_SIZE_HIGHT_CHAR,
                                i*Constans.MAX_SIZE_HIGHT_CHAR*2 ,
                                0));

        }
    }

    public void addCharchters() {
        this.characters = new ArrayList<>();
        for (int i = 0; i < rndNum(Constans.MIN_NUM_OPP, Constans.MAX_NUM_OPP); i++) {
            characters.add(new Pig(
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
