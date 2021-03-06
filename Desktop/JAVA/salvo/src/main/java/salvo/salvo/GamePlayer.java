package salvo.salvo;


import javax.persistence.*;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Date joinDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Player_Id")
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Game_Id")
    private Game game;

    @OneToMany(mappedBy = "gameplayer", fetch = FetchType.EAGER)
    Set<Ship> fleet = new HashSet<>();

    public GamePlayer(Player p1, Game g1) {
        this.player = p1;
        this.game = g1;
        this.joinDate = new Date();
    }

    public GamePlayer() {

    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Long getId() {
        return this.Id;
    }

    public void addship(Ship ship){
        ship.setGameplayer(this);
        this.fleet.add(ship);
    }

}

