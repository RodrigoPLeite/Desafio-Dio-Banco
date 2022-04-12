import java.util.List;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode

public class Banco {
	private String nome;
	private List<Conta> contas;	
	
}
