package rogueslayer;

import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.Sprite;

public class Player extends Entity{

    public Player(RogueSlayer rs) {
        super(new Sprite(RogueSlayer.MEDIA_URL.concat("hero.png")),rs,50,50);
    }


    @Override
    public void update() {

    }

    @Override
    protected void onDeath() {

    }
}
