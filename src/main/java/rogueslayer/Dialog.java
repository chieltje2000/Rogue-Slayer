package rogueslayer;

import nl.han.ica.oopg.objects.TextObject;

import java.awt.event.MouseEvent;

public class Dialog{

    private RogueSlayer rs;
    private Button button;
    private TextObject intro;
    private int buttonX = 565;
    private int buttonY = 400;
    private int textX = 100;
    private int textY = textX;
    public Dialog(RogueSlayer rs) {
        this.rs = rs;
    }

    public void gameIntro(){
        button = new Button( rs,buttonX,buttonY,143,75, "dialog",this);
        rs.addGameObject(button,buttonX,buttonY);
        intro = new TextObject("You have fallen into a cave where there are enemies that are standing in your way.\r\n You are armed with cards you can use to defeat them.\r\n goodluck on your escape.\r\n click on start to go to the game.",20);
        intro.setForeColor(255,0,0,255);
        rs.addGameObject(intro,100,100);
    }

    public void gameWin(){
        button = new Button( rs,buttonX,buttonY,143,75, "menu",this);
        rs.addGameObject(button,buttonX,buttonY);
        intro = new TextObject("You win! but it was all a dream...",20);
        intro.setForeColor(255,0,0,255);
        rs.addGameObject(intro,100,100);
    }

    public void gameLose(){
        button = new Button( rs,buttonX,buttonY,143,75, "menu",this);
        rs.addGameObject(button,buttonX,buttonY);
        intro = new TextObject("you have died.",20);
        intro.setForeColor(255,0,0,255);
        rs.addGameObject(intro,100,100);
    }

    public void removeText(){
        rs.deleteGameObject(intro);
        rs.deleteGameObject(button);
        //intro.setText("");
    }

    public void onClick(MouseEvent e){
        button.onClick(e);
    }

}
