package com.ud21;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GeometriaTest {

    Geometria geo = new Geometria();

    @Test
    public void testAreaCuadrado() {
        assertEquals(25, geo.areacuadrado(5));
    }

    @Test
    public void testAreaCirculo() {
        assertEquals(28.2744, geo.areaCirculo(3), 0.001);
    }

    @Test
    public void testAreaTriangulo() {
        assertEquals(10, geo.areatriangulo(4, 5));
    }

    @Test
    public void testAreaRectangulo() {
        assertEquals(20, geo.arearectangulo(4, 5));
    }

    @Test
    public void testAreaPentagono() {
        assertEquals(30, geo.areapentagono(6, 10));
    }
}