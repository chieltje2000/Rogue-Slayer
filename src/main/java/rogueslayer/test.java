package rogueslayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class test extends JPanel
{
    private BufferedImage bg, hero;
    private int bgWidth, bgHeight;
    private int heroWidth, heroHeight;
    private int scWidth, scHeight;
    private int mouseX, mouseY;

    public test(){
        loadImages();
        init();
        setPreferredSize(new Dimension(scWidth, scHeight));
        addMouseMotionListener(new MouseHandler());
    }

    private void init(){
        mouseX = 0;
        mouseY = 0;
        heroWidth = hero.getWidth();
        heroHeight = hero.getHeight();
        bgWidth = bg.getWidth();
        bgHeight = bg.getHeight();
        scWidth = bgWidth;
        scHeight = bgHeight;
    }

    private void loadImages(){
        try{
            bg = ImageIO.read(getClass().getResource("Images/background.jpg"));
            hero = ImageIO.read(getClass().getResource("Images/knight.png"));
        }catch(IOException ioe){System.out.println("Unable to open file");}
    }

    @Override public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, bgWidth, bgHeight, null);
        g.drawImage(hero, mouseX-(heroWidth/2), mouseY-(heroHeight/2), heroWidth, heroHeight, null);
    }

    private class MouseHandler implements MouseMotionListener
    {
        @Override public void mouseMoved(MouseEvent e){
            mouseX = e.getX();
            mouseY = e.getY();
            repaint();
        }
        @Override public void mouseDragged(MouseEvent e){}
    }
}
