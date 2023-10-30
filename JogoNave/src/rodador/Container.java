package rodador;

import javax.swing.JFrame;
import modelagem.Fase;

public class Container extends JFrame{
    public Container(){
        add(new Fase());
        setTitle("Meu Jogo");
        setSize(1440, 728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
    }

    //teste
    public static void main(String[] args){
        new Container();
    }
}
