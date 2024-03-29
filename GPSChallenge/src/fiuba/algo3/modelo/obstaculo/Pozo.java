package fiuba.algo3.modelo.obstaculo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Camioneta;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Pozo extends Obstaculo {

	public void aplicar(Auto unAuto){
		unAuto.aumentarMovimientosDelJugador(3);
	}
	
	public void aplicar (Moto unaMoto){
		unaMoto.aumentarMovimientosDelJugador(3);
	}
	
	public void aplicar (Camioneta unaCamioneta){
		unaCamioneta.aumentarMovimientosDelJugador(0);
	}
	
	@Override
	public boolean puedeAvanzar(Vehiculo vehiculo) {
		return true;
	}

	@Override
	public Node toXml(Document doc) {
		Element xmlElement = doc.createElement("Pozo");
		return xmlElement;
	}

	@Override
	public boolean tieneBandera() {
		return false;
	}
	
}
