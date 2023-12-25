// Importação necessária para a anotação SpringBootApplication
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotação que marca a classe como uma classe de aplicativo Spring Boot
@SpringBootApplication
public class EstudandoSpringApplication {

  // Método principal que inicia o aplicativo Spring Boot
  public static void main(String[] args) {
    // Chama o método estático run da classe SpringApplication para iniciar o aplicativo
    SpringApplication.run(EstudandoSpringApplication.class, args);
  }
}
