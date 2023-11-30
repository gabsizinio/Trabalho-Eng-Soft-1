package Verificadores;

import java.time.LocalDate;

import ClassesSistema.Livro;
import Usuario.IUsuario;


public class VerificadorAluno implements VerificadorEmprestimo{
	
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
				if(usuario.getEmprestimos().size() < Dias) {
					if(this.TemReserva(usuario, livro)) {
						if(this.TemEmprestimo(usuario, livro) == false) {
							return true;
						}
					}else {
						if(livro.getNumeroReservas() < livro.getNumeroExemplaresDisponiveis()) {
							if(this.TemEmprestimo(usuario, livro) == false) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
}
