package UD09Herencias.Entregables;
public class Videojuego implements Entregable {
    
    private String titulo;
    private int horasEstimadas;
    private boolean entregado;
    private String genero;
    private String compañia;

    private final static int HORAS_ESTIMADAS_DEFECTO = 10;
    private final static boolean ENTREGADO_DEFECTO = false;

    // Constructor por defecto
    public Videojuego() {
        this.titulo = "";
        this.horasEstimadas = HORAS_ESTIMADAS_DEFECTO;
        this.entregado = ENTREGADO_DEFECTO;
        this.genero = "";
        this.compañia = "";
    }

    // Constructor con título y horas estimadas
    public Videojuego(String titulo, int horasEstimadas) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.entregado = ENTREGADO_DEFECTO;
        this.genero = "";
        this.compañia = "";
    }

    // Constructor con todos los atributos excepto entregado
    public Videojuego(String titulo, int horasEstimadas, String genero, String compañia) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.entregado = ENTREGADO_DEFECTO;
        this.genero = genero;
        this.compañia = compañia;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public String getGenero() {
        return genero;
    }

    public String getCompañia() {
        return compañia;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    // Métodos de la interfaz Entregable
    @Override
    public void entregar() {
        this.entregado = true;
    }

    @Override
    public void devolver() {
        this.entregado = false;
    }

    @Override
    public boolean isEntregado() {
        return entregado;
    }

    @Override
    public int compareTo(Object a) {
        Videojuego otro = (Videojuego) a;
        if (this.horasEstimadas > otro.getHorasEstimadas()) {
            return 1;
        } else if (this.horasEstimadas < otro.getHorasEstimadas()) {
            return -1;
        } else {
            return 0;
        }
    }

    // toString
    @Override
    public String toString() {
        return "Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", horasEstimadas=" + horasEstimadas +
                ", entregado=" + entregado +
                ", genero='" + genero + '\'' +
                ", compañia='" + compañia + '\'' +
                '}';
    }
}