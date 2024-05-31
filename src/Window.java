import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
 static JButton latestClicked;
    public Window() {
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(Constans.WIDTH, Constans.HIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        OpeningPanle openningPanel = new OpeningPanle(0,0,Constans.WIDTH, Constans.HIGHT);
        this.add(openningPanel);
        this.repaint();
        MainScene mainScene = new MainScene(0,0,Constans.WIDTH, Constans.HIGHT);
        this.add(mainScene);
        mainScene.setVisible(true);
        openningPanel.setVisible(false);
//        InstructionsPanel instructionsPanel = new InstructionsPanel(0,0,Constans.WIDTH, Constans.HIGHT);
        //this.add(instructionsPanel);
    }

    void changePannel(String name){

    }




    public void setCorrectPannelVisable(JPanel a ){

    }

}
