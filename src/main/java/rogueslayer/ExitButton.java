package rogueslayer;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;


public class ExitButton extends SpriteObject {

    private String typeButton;

    public ExitButton(String type) {
        super(new Sprite("src/main/java/rogueslayer/media/exit.png"));
        this.typeButton = typeButton;
    }

    @Override
    public void update() {

    }
}
