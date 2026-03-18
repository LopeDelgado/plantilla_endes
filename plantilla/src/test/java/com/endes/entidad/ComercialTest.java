package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComercialTest {
	
	


	private Comercial comercial;

	@BeforeEach
	void setUp() {
		comercial = new Comercial("12345678A", "Antonio", "Pérez", 2000.0, 6000.0);
	}

	@Test
	void testConstructor_Valid() {
		assertDoesNotThrow(() -> new Comercial("12345678B", "Juan", "Velazquez", 1200.0, 3000.0));
	}

	@Test
	void testConstructor_InvalidVentas() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> new Comercial("12345678B", "Juan", "Velazquez", 1200.0, -100.0));
		assertEquals("Las ventas no pueden ser negativas", ex.getMessage());
	}

	@Test
	void testGetVentas() {
		assertEquals(6000.0, comercial.getVentas());
	}

	@Test
	void testSetVentas_Valid() {
		assertDoesNotThrow(() -> comercial.setVentas(6000.0));
		assertEquals(6000.0, comercial.getVentas());
	}

	@Test
	void testSetVentas_Invalid() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> comercial.setVentas(-200.0));
		assertEquals("Las ventas no pueden ser negativas", ex.getMessage());
	}
}
