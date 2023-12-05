package Usuario;

import java.util.List;

import java.util.ArrayList;

import java.time.LocalDate;

import Verificadores.VerificadorEmprestimo;
import Verificadores.VerificadorAluno;

import ClassesSistema.Emprestimo;
import ClassesSistema.Livro;
import ClassesSistema.Reserva;
import Console.Console1;
import ClassesSistema.ExemplarLivro;
import ClassesSistema.FabricaClassesSistema;

import Verificadores.FabricaVerificadores;

public class AlunoGrad implements IUsuario{
	private int Id;
	private String Nome;
	private ArrayList<Reserva> Reservas;
	private ArrayList<Emprestimo> Emprestimo;
	private VerificadorEmprestimo Verificador;
	private ArrayList<Emprestimo> EmprestimosPassados;
	
	public AlunoGrad(int Id, String Nome) {
		this.Id = Id;
		this.Nome = Nome;
		
		this.Emprestimo = new ArrayList<Emprestimo>();
		this.Reservas = new ArrayList<Reserva>();
		this.Verificador = FabricaVerificadores.criaVerificadorAluno();
		this.EmprestimosPassados = new ArrayList<Emprestimo>();
	}
	
	public void setVerificador(VerificadorEmprestimo NovoVerificador) {
		this.Verificador = NovoVerificador;
	}
	
	public int getId() {
		return this.Id;
	}
	public String getNome() {
		return this.Nome;
	}
	
	public List<Reserva> getReservas(){
		return this.Reservas;
	}
	public List<Emprestimo> getEmprestimos(){
		return this.Emprestimo;
	}
	
	public String Consulta() {
		String msg = "Emprestimos:";
		
		for(int i = 0; i < this.Emprestimo.size(); i++) {
			msg += "\n" + Emprestimo.get(i).getLivro().getTitulo();
			msg += "\nData de Emprestimo: " + Emprestimo.get(i).getDataPegou();
			msg += "\nData de Devolucao: " + Emprestimo.get(i).getDataDevolver();		
			if(Emprestimo.get(i).getStatus() == true) {
				msg += "\nStatus: Corrente";
			}else {
				msg += "\nStatus: Terminado";
			}
		}
		
		msg += "\nEmprestimos Passados:";
		for(int i = 0; i < this.EmprestimosPassados.size(); i++) {
			msg += "\n" + EmprestimosPassados.get(i).getLivro().getTitulo();
			msg += "\nData de Emprestimo: " + EmprestimosPassados.get(i).getDataPegou();
			//msg += "\nData de Devolucao: " + EmprestimosPassados.get(i).getDataDevolver();		
			if(EmprestimosPassados.get(i).getStatus() == true) {
				msg += "\nStatus: Corrente";
			}else {
				msg += "\nStatus: Terminado";
			}
		}
		
		msg += "\nReservas:";
		
		for(int i = 0; i < this.Reservas.size(); i++) {
			msg += "\n" + Reservas.get(i).getLivro().getTitulo();
			msg += "\nData da Solicitacao: " + Reservas.get(i).getData();
		}
		return msg;
	}
	
	
	public void RemoveReserva(Livro livro) {
		for(int i = 0; i < Reservas.size(); i++) {
			if(Reservas.get(i).getLivro().getTitulo() == livro.getTitulo()) {
				Reservas.remove(i);
				livro.removeReserva(this);
			}
		}
	}
	
	public boolean Emprestimo(Livro livro) {
		//System.out.println("Here");
		if(Verificador.podePegar(this, livro, 3)) {
			ExemplarLivro exemplar = livro.getExemplarDisponivel();
			Emprestimo emp = FabricaClassesSistema.criarEmprestimo(this, exemplar, 3);
			exemplar.setEmprestimo(emp);
			Emprestimo.add(emp);
			this.RemoveReserva(livro);
			return true;
		}
		return false;
	}
	
	
	public boolean Devolver(Livro livro) {
		for(int i = 0; i < Emprestimo.size(); i++) {
			if(Emprestimo.get(i).getLivro() == livro) {
				Emprestimo.get(i).cancelEmprestimo();
				EmprestimosPassados.add(Emprestimo.get(i));
				Emprestimo.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean Reservar(Livro livro) {
		Reserva reserva = FabricaClassesSistema.criarReserva(livro, this);
		if(Reservas.size() < 3) {
			Reservas.add(reserva);
			livro.addReserva(reserva);
			return true;	
		}
		return false;
	}

}
