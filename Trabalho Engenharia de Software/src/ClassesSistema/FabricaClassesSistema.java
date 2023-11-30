package ClassesSistema;

import java.util.List;


import Usuario.IUsuario;

public class FabricaClassesSistema {
	public static Emprestimo criarEmprestimo(IUsuario Usuario, ExemplarLivro Exemplar, int DiasEmprestimo) {
		return new Emprestimo(Usuario, Exemplar, DiasEmprestimo);
	}
	
	public static ExemplarLivro criarExemplar(int id, Livro livro) {
		return new ExemplarLivro(id, livro);
	}
	
	public static Livro criarLivro(int Id, String Titulo, String Editora, List<String> Autores, String Edicao, int AnoDaPublicacao) {
		return new Livro(Id, Titulo, Editora, Autores, Edicao, AnoDaPublicacao);
	}
	
	public static Reserva criarReserva(Livro livro, IUsuario usuario) {
		return new Reserva(livro, usuario);
	}
	
}
