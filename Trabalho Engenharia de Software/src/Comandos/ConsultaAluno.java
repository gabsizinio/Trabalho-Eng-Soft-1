package Comandos;

import Destinatario.Facade;

public class ConsultaAluno implements IComando{
	public String Executar(String p1, String p2) {
		return Facade.AcessarSingleton().ConsultaAluno(Integer.parseInt(p1));
	}
}
