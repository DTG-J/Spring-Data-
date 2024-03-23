package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.entity.Astronomer;

import java.util.Optional;


public interface AstronomerRepository extends JpaRepository<Astronomer, Long> {

    Optional<Astronomer> findByFirstNameAndLastName(String firstName, String lastName);


}
