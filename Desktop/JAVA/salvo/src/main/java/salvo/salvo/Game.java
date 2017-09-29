package salvo.salvo;

import com.sun.swing.internal.plaf.synth.resources.synth_sv;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
    public class Game {


        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long Id;
        private Date creationDate = new Date();

        @OneToMany(mappedBy="game", fetch=FetchType.EAGER)
        Set<GamePlayer> gameplayers = new HashSet<>();

        public Game() {
        }

    public Game(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Set<GamePlayer> getGameplayers() {
        return gameplayers;
    }
}


