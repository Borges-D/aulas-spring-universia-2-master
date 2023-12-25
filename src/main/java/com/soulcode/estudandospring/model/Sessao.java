// Importações necessárias para as anotações JPA
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Declaração da entidade Sessao que será mapeada para uma tabela no banco de dados
@Entity
@Table(name = "sessoes")
public class Sessao {
  
  // Identificador único gerado automaticamente pelo banco de dados
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  // Atributo que representa a data da sessão na tabela "sessoes"
  @Column(nullable = false)
  private LocalDate data;

  // Atributo que representa a hora de início da sessão na tabela "sessoes"
  @Column(nullable = false)
  private LocalTime inicio;

  // Atributo que representa a hora de término da sessão na tabela "sessoes"
  @Column(nullable = false)
  private LocalTime termino;

  // Atributo que representa o preço do ingresso na tabela "sessoes"
  @Column(name = "preco_ingresso", nullable = false)
  private Float precoIngresso;

  // Relacionamento muitos-para-um com a entidade Filme
  @ManyToOne
  @JoinColumn(nullable = false)
  private Filme filme;

  // Construtor padrão vazio necessário para JPA
  public Sessao() {
  }

  // Métodos getters e setters para acessar e modificar os atributos da classe
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public LocalTime getInicio() {
    return inicio;
  }

  public void setInicio(LocalTime inicio) {
    this.inicio = inicio;
  }

  public LocalTime getTermino() {
    return termino;
  }

  public void setTermino(LocalTime termino) {
    this.termino = termino;
  }

  public Float getPrecoIngresso() {
    return precoIngresso;
  }

  public void setPrecoIngresso(Float precoIngresso) {
    this.precoIngresso = precoIngresso;
  }

  public Filme getFilme() {
    return filme;
  }

  public void setFilme(Filme filme) {
    this.filme = filme;
  }
}
