package Observador;
import java.util.List;

public class ObserverManager {
	private List<IObservador> Observadores;
	
	public void Notificar() {
		for(int i = 0; i < Observadores.size(); i++) {
			Observadores.get(i).Notificar();
		}
	}
	
	public void addObs(IObservador NovoObservador) {
		Observadores.add(NovoObservador);
	}
}
