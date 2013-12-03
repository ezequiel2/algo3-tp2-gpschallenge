package fiuba.algo3.modelo;

import java.util.ArrayList;

import fiuba.algo3.modelo.cambiadorDeVisibilidad.ApagadorDeVisibilidad;
import fiuba.algo3.modelo.cambiadorDeVisibilidad.EncendedorDeVisibilidad;
import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;
import fiuba.algo3.modelo.obstaculo.Obstaculo;
import fiuba.algo3.modelo.sorpresa.Sorpresa;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Esquina {
	private boolean visibilidad;
	private Posicion unaPosicion;
	private Vehiculo unVehiculo;
	private Sorpresa unaSorpresa;
	private Obstaculo unObstaculo;

	public Esquina(Posicion posicion) {
		this.unaPosicion = posicion;
		this.visibilidad = false;
	}

	public void setearVehiculo(Vehiculo vehiculo) {
		this.unVehiculo = vehiculo;
		vehiculo.setearEsquina(this);
	}

	public void borrarVehiculo() {
		this.unVehiculo = null;
	}

	public Vehiculo devolverVehiculo() {
		return this.unVehiculo;
	}

	public Posicion devolverPosicion() {
		return this.unaPosicion;
	}

	public void aplicarExtras(Jugador unJugador) {
		if (this.unaSorpresa != null) {
			this.unaSorpresa.aplicar(unJugador);
			this.elimnarSorpresa();
		}
		if (this.unObstaculo != null) {
			this.unObstaculo.aplicar(unJugador);
			// unJugador.devolverVehiculo().interactuarCon(unObstaculo);
		}
	}

	private void elimnarSorpresa() {
		this.unaSorpresa = null;
	}

	public void setearSorpresa(Sorpresa sorpresa) {
		this.unaSorpresa = sorpresa;
	}

	public void encenderVisibilidad() {
		this.visibilidad = true;
	}

	public void apagarVisibilidad() {
		this.visibilidad = false;

	}

	public boolean devolverVisibilidad() {
		return this.visibilidad;
	}

	public void setearObstaculo(Obstaculo obstaculo) {
		this.unObstaculo = obstaculo;
	}

	public Obstaculo devolverObstaculo() {
		return unObstaculo;
	}

	public ArrayList<Posicion> devolverPosicionesADistanciaDeRadio(int radio) {
		ArrayList<Posicion> PosicionesAdyacentes = new ArrayList<Posicion>();
		for (int i = -2; i <= radio; i++) {
			for (int j = -2; j <= radio; j++) {
				Posicion unaPosicionAdyacente = new Posicion(
						this.unaPosicion.devolverPosicionFila() + i,
						this.unaPosicion.devolverPosicionColumna() + j);
				PosicionesAdyacentes.add(unaPosicionAdyacente);
			}
		}
		return PosicionesAdyacentes;
	}

	public Sorpresa devolverSorpresa() {
		return this.unaSorpresa;
	}

	public void borrarObstaculo() {
		this.unObstaculo = null;

	}

	public void borrarSorpresa() {
		this.unaSorpresa = null;

	}

	public boolean equals(Esquina unaEsquina) {
		if ((this.unaPosicion == unaEsquina.devolverPosicion())
				&& (this.unaSorpresa == unaEsquina.devolverSorpresa())
				&& (this.unObstaculo == unaEsquina.devolverObstaculo())
				&& (this.unVehiculo == unaEsquina.devolverVehiculo())
				&& (this.visibilidad == unaEsquina.devolverVisibilidad()))
			return true;
		return false;
	}

	public boolean tieneExtras() {
		if (this.unaSorpresa != null) {
			return true;
		}
		if (this.unObstaculo != null) {
			return true;
		}
		return false;
	}

	public boolean tieneSorpresa() {
		if (this.unaSorpresa != null) {
			return true;
		}
		return false;
	}

	public boolean tieneObstaculo() {
		if (this.unObstaculo != null) {
			return true;
		}
		return false;
	}

	public int obtenerPosicionX() {
		return unaPosicion.devolverPosicionFila();
	}

	public int obtenerPosicionY() {
		return unaPosicion.devolverPosicionColumna();
	}

	public void apagarVisibilidadDosALaRedonda(Mapa unMapa)
			throws ExcepcionEsquinaInvalida {
		ApagadorDeVisibilidad unApagador = new ApagadorDeVisibilidad(unMapa);
		unApagador.apagarVisibilidadDosALaRedonda(this);
	}

	public void encenderVisibilidadDosALaRedonda(Mapa unMapa)
			throws ExcepcionEsquinaInvalida {
		EncendedorDeVisibilidad unEncendedor = new EncendedorDeVisibilidad(
				unMapa);
		unEncendedor.encenderVisibilidadDosALaRedonda(this);
	}

}
