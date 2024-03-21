package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.entity.Constellation;

import java.util.Optional;

// TODO:
public interface ConstellationRepository extends JpaRepository<Constellation, Long> {

    Optional<Constellation> findByName(String name);
}
