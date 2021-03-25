package rogueslayer;

import nl.han.ica.oopg.objects.TextObject;
import java.util.ArrayList;

public class MainMenu extends Screen{

    private final RogueSlayer rs;
    private String text = "test";
    ArrayList<Button> buttons = new ArrayList<Button>();

    protected MainMenu(RogueSlayer rogueSlayer){
        this.rs = rogueSlayer;
    }

    public void setupMainMenu(){
        TextObject Titel = new TextObject("RogueSlayer",40);
        Titel.setForeColor(255,255,255,255);
        rs.addGameObject(Titel,rs.getWorldWidth()/5*2,100);

        Button button = new Button(575,500, 280,280,"Knop");
        addGameObjects(button,575,500);

        TextObject Start = new TextObject("Start",40);
        Start.setForeColor(255,255,0,255);
        rs.addGameObject(Start,580,500);
    }


}
