package rogueslayer;

import nl.han.ica.oopg.objects.TextObject;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainMenu extends Screen{

    private String text = "test";
    ArrayList<Button> buttons = new ArrayList<Button>();
    Button b = new Button("start");
    ExitButton eb = new ExitButton("exit");

    MainMenu(RogueSlayer rogueSlayer){
        super(rogueSlayer);
        setupMainMenu();
    }

    @Override
    protected void updateScreen() {
    //System.out.println("test");
    }

    @Override
    public void MouseClickedScreen(MouseEvent e) {
        b.onClick(e);
    }

    public void setupMainMenu(){
        TextObject Titel = new TextObject("RogueSlayer",40);
        Titel.setForeColor(255,255,255,255);
        rs.addGameObject(Titel,525,100);

        rs.addGameObject(b,565,400);

        rs.addGameObject(eb,557,500);
    }

    private void removeObject(){

    }

}
