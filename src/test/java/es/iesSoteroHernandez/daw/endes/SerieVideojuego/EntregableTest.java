package es.iesSoteroHernandez.daw.endes.SerieVideojuego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EntregableTest {

	@Test
	public void testIsEntregadoVideojuego() {
		Videojuego callOfDuty = new Videojuego("Call of Duty", 40, "Shooter", "Activision");
		assertFalse(callOfDuty.isEntregado());

		callOfDuty.entregar();
		assertTrue(callOfDuty.isEntregado());

		callOfDuty.devolver();
		assertFalse(callOfDuty.isEntregado());
	}

	@Test
	public void testIsEntregadoSerie() {
		Serie vikingos = new Serie("Vikingos", 6, "Drama", "Michael Hirst");
		assertFalse(vikingos.isEntregado());

		vikingos.entregar();
		assertTrue(vikingos.isEntregado());

		vikingos.devolver();
		assertFalse(vikingos.isEntregado());
	}

	@Test
	public void testToStringVideojuego() {
		Videojuego callOfDuty = new Videojuego("Call of Duty", 40, "Shooter", "Activision");
		String cad = "Informacion del videojuego: \n" + "\tTitulo: Call of Duty\n" + "\tHoras estimadas: 40\n"
				+ "\tGenero: Shooter\n" + "\tcompañia: Activision";

		assertEquals(cad, callOfDuty.toString());
	}

	@Test
	public void testToStringSerie() {
		Serie vikingos = new Serie("Vikingos", 6, "Drama", "Michael Hirst");
		String cad = "Informacion de la Serie: \n" + "\tTitulo: Vikingos\n" + "\tNumero de temporadas: 6\n"
				+ "\tGenero: Drama\n" + "\tCreador: Michael Hirst";

		assertEquals(cad, vikingos.toString());
	}

	@Test
	public void testCompareToVideojuego() {
		Videojuego callOfDuty = new Videojuego("Call of Duty", 40, "Shooter", "Activision");
		Videojuego superMario = new Videojuego("Super Mario Bros", 40, "Aventura", "Nintendo");

		assertEquals(Videojuego.IGUAL, callOfDuty.compareTo(superMario));

		superMario.setHorasEstimadas(10);
		assertEquals(Videojuego.MAYOR, callOfDuty.compareTo(superMario));

		superMario.setHorasEstimadas(50);
		assertEquals(Videojuego.MENOR, callOfDuty.compareTo(superMario));

	}

	@Test
	public void testCompareToSerie() {
		Serie vikingos = new Serie("Vikingos", 6, "Drama", "Michael Hirst");
		Serie simpsons = new Serie("Simpsons", 2, "Animacion", "Matt Groening");

		assertEquals(Serie.MAYOR, vikingos.compareTo(simpsons));

		simpsons.setnumeroTemporadas(6);
		assertEquals(Serie.IGUAL, vikingos.compareTo(simpsons));

		simpsons.setnumeroTemporadas(10);
		assertEquals(Serie.MENOR, vikingos.compareTo(simpsons));
	}

	@Test
	public void testEqualsVideojuego() {

		Videojuego callOfDuty = new Videojuego("Call of Duty", 40, "Shooter", "Activision");
		Videojuego cod = new Videojuego("Call of Duty", 50, "Guerra", "Activision");

		assertTrue(callOfDuty.equals(cod));

		cod = new Videojuego("Super Mario Bros", 40, "Aventura", "Nintendo");
		assertFalse(callOfDuty.equals(cod));
	}

	@Test
	public void testEquals() {
		
		Serie vikingos = new Serie("Vikingos", 6, "Drama", "Michael Hirst");
		Serie vikings = new Serie("Vikingos", 8, "Historica", "Michael Hirst");
		Serie simpsons = new Serie("Simpsons", 2, "Animacion", "Matt Groening");

		assertTrue(vikingos.equals(vikings));
		assertFalse(vikingos.equals(simpsons));
	}

}
