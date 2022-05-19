package crudRest.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

/**
 *
 * @author Miguel Castro
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pessoas")
public class PessoaModel extends RepresentationModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "email", nullable = false)
    private String email;

}
