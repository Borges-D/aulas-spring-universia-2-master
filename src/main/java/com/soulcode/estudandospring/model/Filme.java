
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Declaração da entidade Filme que será mapeada para uma tabela no banco de dados
@Entity
@Table(name = "filmes")
public class Filme {

  // Identificador único gerado automaticamente pelo banco de dados
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  // Atributo que representa o título do filme na tabela "filmes"
  @Column(nullable = false, length = 80)
  private String titulo;

  // Atributo que representa a descrição do filme na tabela "filmes"
  @Column(nullable = false)
  private String descricao;

  // Atributo que representa o estúdio do filme na tabela "filmes"
  @Column(nullable = false, length = 50)
  private String estudio;

  // Atributo que representa a classificação do filme na tabela "filmes"
  @Column(nullable = false, length = 50)
  private String classificacao;

  // Construtor padrão vazio necessário para JPA
  public Filme() {
  }

  // Métodos getters e setters para acessar e modificar os atributos da classe
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getEstudio() {
    return estudio;
  }

  public void setEstudio(String estudio) {
    this.estudio = estudio;
  }

  public String getClassificacao() {
    return classificacao;
  }

  public void setClassificacao(String classificacao) {
    this.classificacao = classificacao;
  }
}
