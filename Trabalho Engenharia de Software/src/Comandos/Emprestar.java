package Comandos;

import Destinatario.Facade;

public class Emprestar implements IComando{
	public String Executar(String p1, String p2) {
		return Facade.AcessarSingleton().Emprestar(Integer.parseInt(p1), Integer.parseInt(p2));
	}
}
