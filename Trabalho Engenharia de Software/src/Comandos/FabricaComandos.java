package Comandos;

public class FabricaComandos {
	public static ConsultaAluno criaConsultaAluno() {
		return new ConsultaAluno();
	}
	
	public static ConsultaProfessor criaConsultaProfessor() {
		return new ConsultaProfessor();
	}
	
	public static Devolver criaDevolver() {
		return new Devolver();
	}
	
	public static Emprestar criaEmrestar() {
		return new Emprestar();
	}
	
	public static Observar criaObservar() {
		return new Observar();
	}
	
	public static Reservar criaReservar() {
		return new Reservar();
	}
	
	public static Sair criaSair() {
		return new Sair();
	}
	
	public static ConsultaLivro criaConsultaLivro() {
		return new ConsultaLivro();
	}
}
