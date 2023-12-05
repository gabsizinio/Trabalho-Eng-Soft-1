package Verificadores;

import java.time.LocalDate;

import ClassesSistema.Livro;
import Usuario.IUsuario;

public class VerificadorProf implements VerificadorEmprestimo{
	
	public boolean TemReserva(IUsuario usuario, Livro livro) {
		for(int i = 0; i < usuario.getEmprestimos().size(); i++) {
			if(usuario.getEmprestimos().get(i).getLivro().getTitulo() == livro.getTitulo()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean TemEmprestimo(IUsuario usuario, Livro livro) {
		for(int i = 0; i < usuario.getEmprestimos().size(); i++) {
			if(usuario.getEmprestimos().get(i).getLivro().getTitulo() == livro.getTitulo()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean Devedor(IUsuario usuario) {
		LocalDate hoje = LocalDate.now();
		
		for(int i = 0; i < usuario.getEmprestimos().size(); i++) {
			if(hoje.isAfter(usuario.getEmprestimos().get(i).getDataDevolver())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean podePegar(IUsuario usuario, Livro livro, int Dias) {
		if(livro.exemplarDisponivel()) {
			if(this.Devedor(usuario) == false) {
				//System.out.println("Aqui");
				return true;
			}
		}
		return false;
	}
}
