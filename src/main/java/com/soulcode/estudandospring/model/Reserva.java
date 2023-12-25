// Importações necessárias para as anotações JPA
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Declaração da entidade Reserva que será mapeada para uma tabela no banco de dados
@Entity
@Table(name = "reservas")
public class Reserva {

  // Identificador único gerado automaticamente pelo banco de dados
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  // Atributo que representa a quantidade de reservas na tabela "reservas"
  @Column(nullable = false)
  private Integer quantidade;

  // Atributo que representa a situação da reserva na tabela "reservas"
  @Column(nullable = false, length = 50)
  private String situacao;

  // Relacionamento muitos-para-um com a entidade Cliente
  @ManyToOne
  @JoinColumn(nullable = false)
  private Cliente cliente;

  // Relacionamento muitos-para-um com a entidade Sessao
  @ManyToOne
  @JoinColumn(nullable = false)
  private Sessao sessao;

  // Construtor padrão vazio necessário para JPA
  public Reserva() {
  }

  // Métodos getters e setters para acessar e modificar os atributos da classe
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public String getSituacao() {
    return situacao;
  }

  public void setSituacao(String situacao) {
    this.situacao = situacao;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Sessao getSessao() {
    return sessao;
  }

  public void setSessao(Sessao sessao) {
    this.sessao = sessao;
  }
}
