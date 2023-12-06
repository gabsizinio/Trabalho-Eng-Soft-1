package Comandos;

import Destinatario.Facade;

public class Observar implements IComando{
	public String Executar(String p1, String p2) {
		return Facade.AcessarSingleton().Observar(Integer.parseInt(p1), Integer.parseInt(p2));
	}
}
