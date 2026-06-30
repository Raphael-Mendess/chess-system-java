package chess.model;

import com.chess.model.Player;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("PLAYER_TWO")
@Table(name = "player_two")
public class PlayerTwo extends Player {

    public PlayerTwo() {}

    public PlayerTwo(String name, PlayerColor color) {
        super(name, color);
    }
}