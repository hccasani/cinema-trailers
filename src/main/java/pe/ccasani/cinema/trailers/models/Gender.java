package pe.ccasani.cinema.trailers.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Gender {

  @Id
  @Column(name = "id_gender")
  private Integer id;

  @Column(name = "title_gender")
  private String title;

}
