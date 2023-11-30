package ClassesSistema;

import ClassesSistema.Emprestimo;

public class ExemplarLivro {
	private int Id;
	private Livro Livro;
	private boolean Status;
	private Emprestimo EmprestimoAtual;
	
	
	public ExemplarLivro(int id, Livro livro) {
		this.Id = id;
		this.Livro = livro;
		this.Status = true;
	}
	
	public int getId() {
		return this.Id;
	}
	
	public Livro getLivro() {
		return this.Livro;
	}
	
	public boolean getStatus() {
		return this.Status;
	}
	
	public void setStatus(boolean bool) {
		this.Status = bool;
	}
	
	public void setEmprestimo(Emprestimo emprestimo) {
		this.EmprestimoAtual = emprestimo;
		this.Status = false;
	}
	
	public Emprestimo getEmprestimo() {
		return this.EmprestimoAtual;
	}
}
