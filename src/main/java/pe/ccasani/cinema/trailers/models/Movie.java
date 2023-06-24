package pe.ccasani.cinema.trailers.models;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Movie {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id_movie")
  private Integer id;

  @NotBlank
  private String title;

  @NotNull
  private String synopsis;

  @NotNull
  @DateTimeFormat(iso = DATE)
  private LocalDate releaseDate;

  @NotBlank
  private String youtubeTrailerId;

  private String coverPath;

  @NotEmpty
  @ManyToMany(fetch = LAZY)
  @JoinTable(name = "gender_movie",
      joinColumns = @JoinColumn(name = "id_movie"),
      inverseJoinColumns = @JoinColumn(name = "id_gender"))
  private List<Gender> genderList;

  @Transient
  private MultipartFile cover;
}
