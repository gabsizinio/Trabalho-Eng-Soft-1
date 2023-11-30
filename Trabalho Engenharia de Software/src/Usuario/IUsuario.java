package Usuario;

import java.util.List;
import ClassesSistema.Reserva;
import ClassesSistema.Emprestimo;
import ClassesSistema.Livro;


public interface IUsuario {
	public int getId();
	public String getNome();
	public List<Reserva> getReservas();
	public List<Emprestimo> getEmprestimos();
	
	public boolean Emprestimo(Livro livro);
	public boolean Devolver(Livro livro);
	public boolean Reservar(Livro livro);
	public String Consulta();
	
	
}
