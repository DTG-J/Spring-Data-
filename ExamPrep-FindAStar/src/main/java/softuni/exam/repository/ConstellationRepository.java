package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.entity.Constellation;

// TODO:
public interface ConstellationRepository extends JpaRepository<Constellation, Long> {

}
