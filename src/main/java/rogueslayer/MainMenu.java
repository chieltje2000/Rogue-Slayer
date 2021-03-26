package rogueslayer;

import nl.han.ica.oopg.objects.TextObject;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainMenu extends Screen{

    private String text = "test";
    ArrayList<Button> buttons = new ArrayList<Button>();
    private Button b;

    MainMenu(RogueSlayer rogueSlayer){
        super(rogueSlayer);
        setupMainMenu();
    }

    @Override
    protected void updateScreen() {
     //System.out.println("test");
    }

    @Override
    public void mouseClickedScreen(MouseEvent e) {
        for(Button i: buttons){i.onClick(e);}
    }

    @Override
    public void mouseMovedScreen(MouseEvent e) {
        for(Button i: buttons){i.onHover(e);}
    }

    @Override
    public void addAllGameObjects() {
        TextObject Titel = new TextObject("RogueSlayer",40);
        Titel.setForeColor(255,255,255,255);
        rs.addGameObject(Titel,525,100);

        for (int i = 0; i<buttons.size();i++){
            rs.addGameObject(buttons.get(i),565,i*100 +300);
        }
    }

    public void setupMainMenu(){
        Button menu = new Button(rs, "menu");
        Button start = new Button(rs, "start");
        Button exit = new Button(rs, "exit");

        buttons.add(menu);
        buttons.add(start);
        buttons.add(exit);

       // rs.addGameObject(menu,565,300);
       // rs.addGameObject(start,565,400);
       // rs.addGameObject(exit,557,500);
    }
}
