package rogueslayer;

import nl.han.ica.oopg.objects.TextObject;

import java.awt.event.MouseEvent;

public class Dialog extends Screen{

    protected TextObject intro;

    public Dialog(RogueSlayer rs) {
        super(rs);
    }

    @Override
    protected void updateScreen() {

    }

    @Override
    public void mouseClickedScreen(MouseEvent e) {
        removeText();
    }

    @Override
    public void mouseMovedScreen(MouseEvent e) {

    }

    @Override
    public void addAllGameObjects() {

    }

    public void gameIntro(){
        intro = new TextObject("You have fallen into a cave where there are enemies that are standing in your way.\r\n You are armed with cards you can use to defeat them.\r\n goodluck on your escape.",20);
        intro.setForeColor(255,0,0,255);
        rs.addGameObject(intro,100,100);
    }

    private void removeText(){intro.setText("");}
}
