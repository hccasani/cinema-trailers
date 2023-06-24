package pe.ccasani.cinema.trailers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.ccasani.cinema.trailers.models.Gender;

public interface GenderRepository extends JpaRepository<Gender, Integer> {

}
