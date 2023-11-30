package Comandos;

import Destinatario.Facade;

public class Reservar implements IComando{
	public String Executar(String p1, String p2) {
		return Facade.AcessarSingleton().Reservar(Integer.parseInt(p1),Integer.parseInt(p2));
	}
}
