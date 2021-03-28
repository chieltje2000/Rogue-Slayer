package rogueslayer;

import nl.han.ica.oopg.objects.TextObject;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainMenu extends Screen{

    private String text = "test";
    ArrayList<Button> buttons = new ArrayList<Button>();

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
            rs.addGameObject(buttons.get(i),565,i*100+300);
        }
    }

    public void setupMainMenu(){
        Button menu = new Button(rs,565,300,143,75, "menu");
        Button start = new Button(rs,565,400,143,75, "start");
        Button exit = new Button(rs,565,500,143 ,75, "exit");

        buttons.add(menu);
        buttons.add(start);
        buttons.add(exit);
    }
}
