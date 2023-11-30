package Comandos;

import Destinatario.Facade;

public class ConsultaProfessor implements IComando{
	public String Executar(String p1, String p2) {
		return Facade.AcessarSingleton().ConsultaProfessor(Integer.parseInt(p1));
	}
}
