package Verificadores;

public class FabricaVerificadores {
	public static VerificadorAluno criaVerificadorAluno() {
		return new VerificadorAluno();
	}
	
	public static VerificadorProf criaVerificadorProfessor() {
		return new VerificadorProf();
	}
}
