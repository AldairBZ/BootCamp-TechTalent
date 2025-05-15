package UD09Herencias.Entregables;

public class Main {
    public static void main(String[] args) {

        // Crear arrays de 5 posiciones
        Serie[] series = new Serie[5];
        Videojuego[] videojuegos = new Videojuego[5];

        // Crear objetos con distintos constructores
        series[0] = new Serie(); // Por defecto
        series[1] = new Serie("Breaking Bad", "Vince Gilligan");
        series[2] = new Serie("Stranger Things", 4, "Ciencia ficción", "Hermanos Duffer");
        series[3] = new Serie("Dark", 3, "Misterio", "Baran bo Odar");
        series[4] = new Serie("La Casa de Papel", 5, "Acción", "Álex Pina");

        videojuegos[0] = new Videojuego(); // Por defecto
        videojuegos[1] = new Videojuego("God of War", 20);
        videojuegos[2] = new Videojuego("Zelda: BOTW", 50, "Aventura", "Nintendo");
        videojuegos[3] = new Videojuego("FIFA 22", 15, "Deportes", "EA Sports");
        videojuegos[4] = new Videojuego("Elden Ring", 60, "RPG", "FromSoftware");

        // Entregar algunos videojuegos y series
        series[1].entregar();
        series[3].entregar();

        videojuegos[0].entregar();
        videojuegos[3].entregar();
        videojuegos[4].entregar();

        // Contar los entregados y devolverlos
        int seriesEntregadas = 0;
        int juegosEntregados = 0;

        for (Serie serie : series) {
            if (serie.isEntregado()) {
                seriesEntregadas++;
                serie.devolver();
            }
        }

        for (Videojuego videojuego : videojuegos) {
            if (videojuego.isEntregado()) {
                juegosEntregados++;
                videojuego.devolver();
            }
        }

        // Mostrar cuántos fueron entregados
        System.out.println("Series entregadas: " + seriesEntregadas);
        System.out.println("Videojuegos entregados: " + juegosEntregados);

        // Encontrar la serie con más temporadas
        Serie serieMayor = series[0];
        for (int i = 1; i < series.length; i++) {
            if (series[i].compareTo(serieMayor) > 0) {
                serieMayor = series[i];
            }
        }

        // Encontrar el videojuego con más horas estimadas
        Videojuego videojuegoMayor = videojuegos[0];
        for (int i = 1; i < videojuegos.length; i++) {
            if (videojuegos[i].compareTo(videojuegoMayor) > 0) {
                videojuegoMayor = videojuegos[i];
            }
        }

        // Mostrar los de mayor duración
        System.out.println("\nSerie con más temporadas:\n" + serieMayor);
        System.out.println("Videojuego con más horas estimadas:\n" + videojuegoMayor);
    }
}
