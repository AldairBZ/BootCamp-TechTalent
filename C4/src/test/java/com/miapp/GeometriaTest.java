package com.miapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GeometriaTest {

    Geometria geo = new Geometria();

    @Test
    public void testAreaCuadrado() {
        assertEquals(25, geo.areaCuadrado(5));
    }

    @Test
    public void testAreaCirculo() {
    	assertEquals(Math.PI * 3 * 3, geo.areaCirculo(3), 0.001);
    }

    @Test
    public void testAreaTriangulo() {
        assertEquals(10, geo.areaTriangulo(4, 5));
    }

    @Test
    public void testAreaRectangulo() {
        assertEquals(20, geo.areaRectangulo(4, 5));
    }

    @Test
    public void testAreaPentagono() {
        assertEquals(30, geo.areaPentagono(6, 10));
    }
}