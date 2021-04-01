package rogueslayer;


import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Player extends Entity{

    ArrayList<Card> cards = new ArrayList<Card>();
    Enemy enemy;
    private int cardWidth = 120;
    private int cardHeight = 191;
    private int limit = 3;
    Dialog dl;

    public Player(RogueSlayer rs) {
        super(rs,"hero",50,50);
    }


    @Override
    public void update() {

    }

    @Override
    protected void onDeath(Entity entity) {
        if (entity.hp < 0){
            dl.gameLose();
        }
    }

    protected void generateCard() {
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        if (randomNumber == 0) {
            Card atk = new ATK(rs,enemy,cardWidth,cardHeight);
            cards.add(atk);
            System.out.println("attack");
        } else if (randomNumber == 1) {
            Card def = new DEF(rs,this,cardWidth,cardHeight);
            cards.add(def);
            System.out.println("defense");
        } else if (randomNumber == 2) {
            Card heal = new HEAL(rs,this,cardWidth,cardHeight);
            cards.add(heal);
            System.out.println("heal");
        }
    }

    public void onClick(MouseEvent e) {
        for(Card i: cards){i.onClick(e);}
    }
    public void onHover(MouseEvent e) {
        for(Card i: cards){i.onHover(e);}
    }
    protected void addAllGameObjects(){
        generateCard();
        generateCard();
        generateCard();
        generateCard();
        generateCard();

      /*  Card card_1 = new ATK(rs);
        Card card_2 = new ATK(rs);
        Card card_3 = new ATK(rs);

        rs.addGameObject(card_1,400, 500);
        rs.addGameObject(card_2,500, 500);
        rs.addGameObject(card_3,600, 500);*/

        for (int i = 0; i<cards.size(); i++) {
            rs.addGameObject(cards.get(i), i*150+275, 500);
            cards.get(i).cardText(rs);
        }
    }
}
