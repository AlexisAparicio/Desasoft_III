package ED;
import javax.swing.UIManager;

public class juegogato {

    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("Error Nimbus: "+ ex.getMessage());
        }

       MainFrame mf = new MainFrame();
       mf.setVisible(true);     
        


    }
}