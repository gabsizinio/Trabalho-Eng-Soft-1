package Console;

import java.util.Scanner;
import Comandos.FabricaComandos;

import Comandos.IComando;

import java.util.Map;
import java.util.HashMap;

public class Console1 {
	Map<String, IComando> Mapa;
	public Console1() {
		Mapa = new HashMap<>();
		Mapa.put("liv", FabricaComandos.criaConsultaLivro());
		Mapa.put("ntf", FabricaComandos.criaConsultaProfessor());
		Mapa.put("usu", FabricaComandos.criaConsultaAluno());
		Mapa.put("emp", FabricaComandos.criaEmrestar());
		Mapa.put("dev", FabricaComandos.criaDevolver());
		Mapa.put("obs", FabricaComandos.criaObservar());
		Mapa.put("res", FabricaComandos.criaReservar());
		Mapa.put("sai", FabricaComandos.criaSair());
	}
	
	public String[] DivideEntrada(String input) {
		String[] RP = {null,null,null};
		
		//3 elementos, pois temos o padrao 'comando' 'p1' 'p2', por conta do 'executar' da interface de comandos.
		
		String[] Divide = input.split(" ", 3);
		
		for(int i = 0; i < Divide.length; i++) {
			RP[i] = Divide[i];
		}
		
		//Como ha comandos com 1 parametro, ao escrever apenas um comando, o terceiro elemento de RP
		//permanece NULL, assim passamos NULL para o comando com um so parâmetro, e ele nao vai utiliza-lo.
		
		return RP;
	}
	
	public void Executar() {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		String[] par = DivideEntrada(input);
		
		String msg = Mapa.get(par[0]).Executar(par[1], par[2]);
		System.out.println(msg);
	}
	
}
