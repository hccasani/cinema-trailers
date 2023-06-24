package pe.ccasani.cinema.trailers.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.ccasani.cinema.trailers.models.Movie;
import pe.ccasani.cinema.trailers.repositories.GenderRepository;
import pe.ccasani.cinema.trailers.repositories.MovieRepository;
import pe.ccasani.cinema.trailers.service.StoreService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
  private final MovieRepository movieRepository;
  private final GenderRepository genderRepository;
  private final StoreService storeService;

  @GetMapping("")
  public ModelAndView viewHomePage(@PageableDefault(sort = "title", size = 5) Pageable pageable) {
    var movies = movieRepository.findAll(pageable);
    return new ModelAndView("index").addObject("movies", movies);
  }

  @GetMapping("/movies/new")
  public ModelAndView showNewMovieForm() {
    var genderList = genderRepository.findAll(Sort.by("title"));
    return new ModelAndView("admin/new-movie")
        .addObject("movie", new Movie())
        .addObject("genderList", genderList);
  }
}
