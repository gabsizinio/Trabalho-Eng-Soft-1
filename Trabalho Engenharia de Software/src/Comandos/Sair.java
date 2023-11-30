package Comandos;

import Destinatario.Facade;

public class Sair implements IComando{
	public String Executar(String p1, String p2) {
		return Facade.AcessarSingleton().Sair();
	}
}
