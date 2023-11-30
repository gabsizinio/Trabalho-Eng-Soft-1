package Usuario;

public class FabricaUsuario {
	public static AlunoGrad criaAlunoGrad(int Id, String Nome) {
		return new AlunoGrad(Id, Nome);
	}
	
	public static AlunoPos criaAlunoPos(int Id, String Nome) {
		return new AlunoPos(Id, Nome);
	}
	
	public static Professor criaProfessor(int Id, String Nome) {
		return new Professor(Id, Nome);
	}
}
