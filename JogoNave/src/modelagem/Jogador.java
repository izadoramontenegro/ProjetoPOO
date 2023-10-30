package modelagem;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Jogador {
    private int x, y;
    private int dx, dy;
    private Image imagem;
    private int altura, largura;
    private List <Tiro> tiros;
    

    public Jogador(){
        this.x = 550;
        this.y = 480;

        tiros = new ArrayList<Tiro>();
    }

    public void load() {
        ImageIcon referencia = new ImageIcon("imgs//naveJogo.png");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
    }

    public void update() {
        if(y<510 && y>-100) {
            y += dy;
        }
        else;
        
        x += dx;
        

    }

    public void tiroSimples(){
        this.tiros.add(new Tiro(x-10, y-40));
    }

    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        
        if (codigo == KeyEvent.VK_X) {
            tiroSimples();
        }

        if (codigo == KeyEvent.VK_UP) {
            dy = -3;
        }

        if (codigo == KeyEvent.VK_DOWN) {
            dy = 3;
        }

        if (codigo == KeyEvent.VK_LEFT) {
            dx = -3;
        }

        if (codigo == KeyEvent.VK_RIGHT) {
            dx = 3;
        }

    }

    public void keyReleased(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (codigo == KeyEvent.VK_DOWN) {
            dy = 0;
        }

        if (codigo == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (codigo == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }

    public List<Tiro> getTiros() {
        return tiros;
    }

    public void setTiros(List<Tiro> tiros) {
        this.tiros = tiros;
    }


    

}
