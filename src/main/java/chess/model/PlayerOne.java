package chess.model;
 
import chess.model.Player;

import jakarta.persistence.*;
 
@Entity
@DiscriminatorValue("PLAYER_ONE")
@Table(name = "player_one")
public class PlayerOne extends Player {
 
    public PlayerOne() {}
 
    public PlayerOne(String name, PlayerColor color) {
        super(name, color);
    }
}
 