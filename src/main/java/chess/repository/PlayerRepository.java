package chess.repository;

import chess.model.PlayerColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import chess.model.Player;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByName(String name);

    List<Player> findByColor(PlayerColor color);

    List<Player> findAllByOrderByWinsDesc();
}