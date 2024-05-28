import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(Constans.WIDTH, Constans.HIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        MainScene mainScene = new MainScene(0,0,Constans.WIDTH, Constans.HIGHT);
        this.add(mainScene);
    }
}
