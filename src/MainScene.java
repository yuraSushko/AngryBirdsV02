import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MainScene extends JPanel {

    private ArrayList<Pig> characters;
    private ArrayList<Bird> birds;
    private int counterThrown;
    public static Terrein terrein;
    private GameActionListener gameActionListener;
    private Image backroundMainGame;
    private JButton exit;
    public MainScene (int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        this.setLayout(null);
        this.exit =new JButton(Constans.EXIT_BUTTON_TEXT);
        exit.setBounds(Constans.EXIT_BUTTON_X
                ,Constans.EXIT_BUTTON_Y
                ,Constans.EXIT_BUTTON_WIDTH
                ,Constans.EXIT_BUTTON_HIGHT);
        exit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setFocusable(false);
        this.add(exit);
        terrein = new Terrein();
        terrein.randomTerreain();
        terrein.slingshot();
        this.backroundMainGame = new ImageIcon(getClass().getResource("resources/angryBirdsGrassImages.png")).getImage();
        this.addCharchters();
        this.addBirds();
        this.mainGameLoop();

        this.gameActionListener = new GameActionListener(birds);
        this.addMouseListener(gameActionListener);
        this.addMouseMotionListener(gameActionListener); // for drag



    }
    public JButton getExitButton(){
        return this.exit;
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
            c.drawCharacter(g );
        }
        terrein.printPiller(g);
        terrein.printSlingshot(g);
        for(Bird bird : this.birds) {
            bird.drawCharacter(g);
        }

    }


   /* void mainGameLoop(){
        new Thread ( ()->{
            try {
                while (true){
                    for(Character c : this.characters) {
                        //c.checkCollision -> dies or stas in palace if on piller
                        c.gravity();
                    }
                    repaint();
                    // if you make higther you can reduse speed of game
                    Thread.sleep(20);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }*/

    void mainGameLoop() {
        for (Character c : this.characters) {
            new Thread(() -> {
                try {
                    while (true) {

                        //c.checkCollision -> dies or stas in palace if on piller
                        c.gravity();

                        //repaint();
                        // if you make higther you can reduse speed of game
                        Thread.sleep(20);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

    public void addBirds(){
        this.birds = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            birds.add(new Bird(Constans.WIDTH_CHARACTER,
                    Constans.HIGHT_CHARACTER,
                                i*Constans.HIGHT_CHARACTER*2 ,
                                0,Constans.BIRD_REGULAR_IMAGE_PATH));

        }
    }

    public void addCharchters() {
        //int sizeWidth, int sizeHight, int x, int y
        this.characters = new ArrayList<>();
        for (int i = 0; i < terrein.getPillers().size(); i++) {
            Rectangle curr = terrein.getPillers().get(i);
            characters.add(new Pig(Constans.WIDTH_CHARACTER,Constans.HIGHT_CHARACTER,
                            curr.x + (curr.width/2)- Constans.WIDTH_CHARACTER/2,
                               curr.y -(Constans.HIGHT_CHARACTER),
                            Constans.PIG_IMAGE_PATH)
                    );
            System.out.println(characters.get(i));
        }
    }

    public int rndNum(int min,int max ){
        return  new Random().nextInt(min,max+1);
    }









}
