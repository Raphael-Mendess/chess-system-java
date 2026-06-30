package chess.repository;

import chess.model.PlayerTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerTwoRepository extends JpaRepository<PlayerTwo, Long> {
}