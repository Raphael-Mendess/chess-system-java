package chess.repository;

import chess.model.PlayerOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerOneRepository extends JpaRepository<PlayerOne, Long> {
}