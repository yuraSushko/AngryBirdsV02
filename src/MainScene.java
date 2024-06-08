import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class MainScene extends JPanel {

    //private ArrayList<Pig> pigs;
    //private ArrayList<Bird> birds;
    private ArrayList<Character> pigs;
    private ArrayList<Character> birds;
    private int counterThrown;
    public static Terrein terrein;
    private GameActionListener gameActionListener;
    private Image backroundMainGame;
    private JButton exit;
    public MainScene (int x, int y, int width, int height) throws IOException {
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
        terrein.restBench();
        terrein.bottom();
        this.backroundMainGame = new ImageIcon(Objects.requireNonNull(getClass().getResource(Constans.MAIN_SCENE_BACK_IMG))).getImage();
        this.addPigsOnPillers();
        this.addBirds();
        this.mainGameLoop();
        this.gameActionListener = new GameActionListener(birds);
        this.addMouseListener(gameActionListener);
        this.addMouseMotionListener(gameActionListener); // for drag



    }
    public JButton getExitButton(){
        return this.exit;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.backroundMainGame,0,0,Constans.WINDOW_WIDTH,Constans.WINDOW_HIGHT,this);

        for(/*Bird*/ Character c : this.pigs) {
            c.drawCharacter(g );
        }
        terrein.printPiller(g);
        terrein.printSlingshot(g);
        for(/*Bird*/ Character bird : this.birds) {
            bird.drawCharacter(g);
        }
        terrein.printRestBench(g);
        terrein.printBottom(g);

    }



    void mainGameLoop() {

            new Thread(() -> {
                try {
                    /*Bird*/ Character birdToRemove=null;
                    /*Bird*/ Character pigToRemove=null;
                    while (true) {
                        for (Character c : this.pigs  )  {
                            for( Character birdCol : this.birds) {
                                if(c.getCharacterAsRectangle().intersects(birdCol.getCharacterAsRectangle())){
                                    pigToRemove=c; break;
                                }
                            }


                                c.gravity();
                        }
                        for( Character b : this.birds){
                            b.gravity();
                            b.moveUp(b.getMoveUpIncremet());
                            b.moveRight(b.getMoveRightIncremet());
                            if(b.collisionWithBottom() || b.collisionWithPiller() || !b.withinBounds()){
                                birdToRemove=b;
                            }
                        }
                        birds.remove(birdToRemove);
                        pigs.remove(pigToRemove);
                        birdToRemove=null; pigToRemove=null;

                        if(this.birds.size()==0){
                            restokBirds();

                        }
                        if(this.pigs.size()==0){
                            refreshPillersAndPigs();
                            //TODO add points for level cpmplete
                        }


                        Thread.sleep(20);
                    }
                } catch (Exception e) {throw new RuntimeException(e);}
            }).start();
    }



    public void refreshPillersAndPigs(){
        this.terrein.deleteAllPillers();
        this.terrein.randomTerreain();
        this.addPigsOnPillers();
    }

    public void restokBirds(){
        this.addBirds();
    }


    public void addBirds(){
        this.birds = new ArrayList<>();
        for (int i = 0; i <Constans.NUMBER_OF_BIRDS; i++) {
            birds.add(new Bird(Constans.WIDTH_CHARACTER,
                    Constans.HIGHT_CHARACTER,
                    (int) (i*Constans.HIGHT_CHARACTER *1.2  +50),// BUFFER
                                0,Constans.BIRD_REGULAR_IMAGE_PATH));

        }
    }
//addCharchters
    public void addPigsOnPillers() {
        this.pigs = new ArrayList<>();
        for (int i = 0; i < terrein.getPillers().size(); i++) {
            Rectangle curr = terrein.getPillers().get(i);
            pigs.add(new Pig(Constans.WIDTH_CHARACTER,Constans.HIGHT_CHARACTER,
                            curr.x + (curr.width/2)- Constans.WIDTH_CHARACTER/2,
                               curr.y -(Constans.HIGHT_CHARACTER),
                            Constans.PIG_IMAGE_PATH)
                    );
            System.out.println(pigs.get(i));
        }
    }

    public int rndNum(int min,int max ){
        return  new Random().nextInt(min,max+1);
    }









}
