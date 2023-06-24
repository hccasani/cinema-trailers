package pe.ccasani.cinema.trailers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.ccasani.cinema.trailers.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
