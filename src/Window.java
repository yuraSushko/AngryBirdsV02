import javax.swing.*;

public class Window extends JFrame {
    static String latestClickedButton;
    private OpeningPanle openningPanel;
    private MainScene mainScene;
    private InstructionsPanel instructionsPanel;
    private PanelChencherListner panelChencherListner;
    public Window() {
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(Constans.WIDTH, Constans.HIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.panelChencherListner = new PanelChencherListner();
        latestClickedButton= "EMPTY";
        this.openningPanel = new OpeningPanle(0,0,Constans.WIDTH, Constans.HIGHT);
        this.openningPanel.getPlayB().addActionListener(panelChencherListner);
        this.openningPanel.getInstructionsB().addActionListener(panelChencherListner);
        this.add(openningPanel);

        openningPanel.setVisible(true);
        this.mainScene = new MainScene(0,0,Constans.WIDTH, Constans.HIGHT);
        this.mainScene.getExitButton().addActionListener(panelChencherListner);
        this.add(mainScene);
        mainScene.setVisible(false);
        this.instructionsPanel = new InstructionsPanel(0,0,Constans.WIDTH, Constans.HIGHT);
        this.instructionsPanel.getExitButton().addActionListener(panelChencherListner);
        this.add(instructionsPanel);
        instructionsPanel.setVisible(false);
        this.repaint();
        changePannel();

    }

    void changePannel(){
        new Thread(()->{
            while (true){
               /* System.out.println(this.mainScene.isVisible());
                System.out.println(latestClickedButton.equals(Constans.PLAY_BUTTON_TEXT));
                System.out.println(Constans.PLAY_BUTTON_TEXT);*/
                if (latestClickedButton.equals(Constans.EXIT_BUTTON_TEXT) &&
                    this.openningPanel.isVisible()==false ){
                    this.mainScene.setVisible(false);
                    this.instructionsPanel.setVisible(false);
                    this.openningPanel.setVisible(true);
                    repaint();
                }

                else if(latestClickedButton.equals(Constans.PLAY_BUTTON_TEXT) &&
                        this.mainScene.isVisible()==false){
                    System.out.println("changing to main");
                    this.instructionsPanel.setVisible(false);
                    this.openningPanel.setVisible(false);
                    this.mainScene.setVisible(true);
                    repaint();
                }


                else if(latestClickedButton.equals(Constans.INSTRUCTIONS_BUTTON_TEXT) &&
                        this.instructionsPanel.isVisible()==false ){
                    this.openningPanel.setVisible(false);
                    this.mainScene.setVisible(false);
                    this.instructionsPanel.setVisible(true);
                    repaint();
                }
                repaint();

            }
        }).start();
    }






}
