package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;

public interface StarRepository extends JpaRepository<Star, Long> {

}
