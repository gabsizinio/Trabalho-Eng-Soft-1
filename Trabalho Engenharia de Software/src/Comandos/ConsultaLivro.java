package Comandos;

import Destinatario.Facade;

public class ConsultaLivro implements IComando{
	public String Executar(String p1, String p2) {
		return Facade.AcessarSingleton().ConsultaLivro(Integer.parseInt(p1));
	}
}
