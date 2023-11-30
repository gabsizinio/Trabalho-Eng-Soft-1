package Verificadores;

import Usuario.IUsuario;
import ClassesSistema.Livro;

public interface VerificadorEmprestimo {
	public boolean podePegar(IUsuario usuario, Livro livro, int Dias);
}
