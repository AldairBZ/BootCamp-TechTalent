package UD09Herencias.Entregables;

public interface Entregable {
    void entregar();
    void devolver();
    boolean isEntregado();
    int compareTo(Object a); // compara duración (horas o temporadas)
}
