import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpeningPanle extends JPanel {

    private Image backroundOpenening;
    private JButton playB;
    private JButton instructionsB;
    public OpeningPanle(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setBackground(Color.BLACK);
//        this.backroundOpenening = new ImageIcon(getClass().getResource("resources/angryBirdsStartPage.png")).getImage();
        this.backroundOpenening = new ImageIcon(getClass().getResource("resources/angryBirdsInstructions.png")).getImage();
        this.setLayout(null);
        this.playB =new JButton(Constans.PLAY_BUTTON_TEXT);
        playB.setBounds(Constans.OPENINIG_SCREEN_PLAY_BUTTON_X
                ,Constans.OPENINIG_SCREEN_PLAY_BUTTON_Y
                ,Constans.OPENINIG_SCREEN_BOTH_BUTTON_WIDTH
                ,Constans.OPENINIG_SCREEN_BOTH_BUTTON_HIGHT);
        this.instructionsB =new JButton(Constans.INSTRUCTIONS_BUTTON_TEXT);
        instructionsB.setBounds(Constans.OPENINIG_SCREEN_INSTRUCTIONS_BUTTON_X
                ,Constans.OPENINIG_SCREEN_INSTRUCTIONS_BUTTON_Y
                ,Constans.OPENINIG_SCREEN_BOTH_BUTTON_WIDTH
                ,Constans.OPENINIG_SCREEN_BOTH_BUTTON_HIGHT);
        playB.setFont(new Font("Tahoma", Font.PLAIN, 50));
        playB.setContentAreaFilled(false);
        playB.setBorderPainted(false);
        playB.setFocusable(false);
        //playB.setIcon( new ImageIcon(getClass().getResource("resources/angryBirdsInstructions.png")));
        instructionsB.setFocusable(false);
        instructionsB.setBorderPainted(false);
        instructionsB.setContentAreaFilled(false);
        instructionsB.setFont(new Font("Tahoma", Font.PLAIN, 50));

        this.add(playB);

        this.add(instructionsB);


//        this.setVisible(true);
//        this.setFocusable(true);
//        this.requestFocus();

    }

    public JButton getPlayB() {
        return playB;
    }

    public JButton getInstructionsB() {
        return instructionsB;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.backroundOpenening,0,0,Constans.WIDTH,Constans.HIGHT,this);


    }


}