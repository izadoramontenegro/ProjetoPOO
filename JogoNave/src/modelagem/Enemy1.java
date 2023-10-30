package modelagem;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy1 {
    private Image imagem;
    private int x, y;
    private int largura, altura;
    private boolean isVisible;

    //private static final int LARGURA = 938;
    private static int VELOCIDADE = 3;

    public Enemy1(int x, int y) {
        this.x = x;
        this.y = y;
        isVisible = true;
    }

    public void load(){
        ImageIcon referencia = new ImageIcon("imgs//inimigoBasico.png");
        imagem = referencia.getImage();

        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }

    public void update(){
        this.y += VELOCIDADE;
        //if(this.x>LARGURA){
            //isVisible = false;
        //}
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int vELOCIDADE) {
        VELOCIDADE = vELOCIDADE;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    
    
}
