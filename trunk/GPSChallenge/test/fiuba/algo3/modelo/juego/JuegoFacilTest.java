package fiuba.algo3.modelo.juego;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.excepcion.ExcepcionEsquinaInvalida;

public class JuegoFacilTest {

	@Test
	public void testJuegoFacilDeberiaTener1DeCadaSorpresaYObstaculo() throws ExcepcionEsquinaInvalida {
		JuegoFacil unJuegoFacil = new JuegoFacil();
		assertTrue(unJuegoFacil.devolverCantidadDeCambiosDeVehiculos() == 1);
		assertTrue(unJuegoFacil.devolverCantidadDeControlesPoliciales() == 1);
		assertTrue(unJuegoFacil.devolverCantidadDeDesfavorables() == 1);
		assertTrue(unJuegoFacil.devolverCantidadDeFavorables() == 1);
		assertTrue(unJuegoFacil.devolverCantidadDePiquetes() == 1);
		assertTrue(unJuegoFacil.devolverCantidadDePozos() == 1);

	}

}