package rogueslayer;

import nl.han.ica.oopg.objects.TextObject;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainMenu extends Screen{

    private ExitButton exit;
    private String text = "test";
    ArrayList<Button> buttons = new ArrayList<Button>();
    Button b = new Button("banaan");


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

        Button Start = new Button("start");
        rs.addGameObject(Start,565,400);
        creatExit();
       // Button Exit = new Button("exit");
       // rs.addGameObject(Exit,565,500);
    }

    private void creatExit(){
        exit = new ExitButton(this);
        rs.addGameObject(exit,565,500);
    }
}
