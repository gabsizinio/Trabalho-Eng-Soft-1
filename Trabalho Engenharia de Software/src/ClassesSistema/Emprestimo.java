package ClassesSistema;
import java.time.LocalDate;
import Usuario.IUsuario;


public class Emprestimo {
	private IUsuario Usuario;
	private ExemplarLivro Exemplar;
	private LocalDate DataPegou;
	private LocalDate DataDevolver;
	private boolean Estado;
	
	public Emprestimo(IUsuario Usuario, ExemplarLivro Exemplar, int DiasEmprestimo) {
		this.Usuario = Usuario;
		this.Exemplar = Exemplar;
        this.DataPegou = LocalDate.now();
        this.DataDevolver = LocalDate.now().plusDays(DiasEmprestimo);
        this.Estado = true;
	}
	
	public IUsuario getUsario() {
		return this.Usuario;
	}
	
	public ExemplarLivro getExemplar() {
		return this.Exemplar;
	}
	
	public Livro getLivro() {
		return this.Exemplar.getLivro();
	}
	
	public void cancelEmprestimo() {
		this.Estado = false;
	}
	
	public LocalDate getDataPegou() {
		return this.DataPegou;
	}
	
	public LocalDate getDataDevolver() {
		return this.DataDevolver;
	}
	
	public boolean getStatus() {
		return this.Estado;
	}
	
}
