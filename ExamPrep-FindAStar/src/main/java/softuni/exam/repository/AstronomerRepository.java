package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.entity.Astronomer;


public interface AstronomerRepository extends JpaRepository<Astronomer, Long> {

}
