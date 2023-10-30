package modelagem;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {
    private Jogador player;
    private Image fundo;
    private Timer timer;
    private List<Enemy1> enemy1;

    public Fase() {
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon referencia = new ImageIcon("imgs//fundoJogo.png");
        fundo = referencia.getImage();

        player = new Jogador();
        player.load();

        addKeyListener(new TecladoAdapter());

        timer = new Timer(5, this);
        timer.start();

        inicializaInimigos();
    }

    public void inicializaInimigos() {
        int coordenadas[] = new int[50];
        // usar isso pro sistema de dificuldade
        enemy1 = new ArrayList<Enemy1>();

        //usaria um while pontuação<1000 ou x valor
        for (int i = 0; i < coordenadas.length; i++) {
            int x = (int)(Math.random() * -1500+1400);
            int y = (int)(Math.random() * -4500);
            enemy1.add(new Enemy1(x, y));
        }

    }

    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

        List<Tiro> tiros = player.getTiros();

        for (int i = 0; i < tiros.size(); i++) {
            Tiro m = tiros.get(i);
            m.load();
            graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
        }


        for (int i = 0; i < enemy1.size(); i++) {
            Enemy1 in = enemy1.get(i);
            in.load();;
            graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
        }


        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        List<Tiro> tiros = player.getTiros();

        for (int i = 0; i < tiros.size(); i++) {
            Tiro m = tiros.get(i);
            if (m.isVisible()) {
                m.update();
                ;
            } else {
                tiros.remove(i);
            }
        }

        for (int i = 0; i < enemy1.size(); i++) {
            Enemy1 in = enemy1.get(i);
            if(in.isVisible()){
                in.update();
            }
            else{
                enemy1.remove(i);
            }
        }

        repaint();

    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }
}
