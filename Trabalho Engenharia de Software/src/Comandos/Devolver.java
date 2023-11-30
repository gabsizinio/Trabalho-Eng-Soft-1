package Comandos;

import Destinatario.Facade;

public class Devolver implements IComando{
	public String Executar(String p1, String p2) {
		return Facade.AcessarSingleton().Devolver(Integer.parseInt(p1), Integer.parseInt(p2));
	}
}
