package App;

import View.NewJFrame;

public class Main {

    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewJFrame frame = new NewJFrame();
                frame.setLocationRelativeTo(null); // Mengatur frame di tengah
                frame.setVisible(true);
            }
        });
    }

}
