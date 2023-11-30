import Destinatario.Facade;

public class Progrma {
	public static void main(String[] args) {
		Facade Biblioteca = Facade.AcessarSingleton();
		
		Biblioteca.Run();
	}
}
