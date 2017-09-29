package salvo.salvo;

import javax.persistence.*;
import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Ship_Id")
    private GamePlayer gameplayer;

    private String type;

    @ElementCollection
    private List<String> location = new ArrayList<>();

    public Ship() {
    }



    public Ship(String type, List<String> location) {
        this.type = type;
        this.location = location;
    }

    public Long getId() {
        return Id;
    }

    public GamePlayer getGameplayer() {
        return gameplayer;
    }

    public void setGameplayer(GamePlayer gameplayer) {
        this.gameplayer = gameplayer;
    }
}