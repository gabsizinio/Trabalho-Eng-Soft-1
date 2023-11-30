package ClassesSistema;
import java.time.LocalDate;

import Usuario.IUsuario;


public class Reserva {
	private Livro Livro;
	private IUsuario Usuario;
	private LocalDate Data;
	
	public Reserva(Livro Livro, IUsuario usuario){
		this.Livro = Livro;
		this.Usuario = usuario;
		this.Data = LocalDate.now();
	}
	
	public Livro getLivro() {
		return this.Livro;
	}
	
	public IUsuario getUsuario() {
		return this.Usuario;
	}
	
	public LocalDate getData() {
		return this.Data;
	}
}
