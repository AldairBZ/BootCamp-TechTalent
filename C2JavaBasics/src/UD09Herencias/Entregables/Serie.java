package UD09Herencias.Entregables;

public class Serie implements Entregable {
	
	//Atributos
	private String titulo;
	private int numTemporadas;
	private boolean entregado;
	private String genero;
	private String creador;
	
	//constantes por defecto
	private final static int TEMPORADAS_DEF = 3;
	private final static boolean ENTREGADO_DEF = false;
	
	//Contructor por defecto
	public Serie() {
		this.titulo = "";
		this.numTemporadas = TEMPORADAS_DEF;
		this.entregado = ENTREGADO_DEF;
		this.genero = "";
		this.creador = "";
		
	}
	
	//Contructor con titulo y creador 
	public Serie(String titulo, String creador) {
		this.titulo = titulo;
		this.creador = creador;
		this.numTemporadas = TEMPORADAS_DEF;
		this.entregado = ENTREGADO_DEF;
		this.genero = "";
	}
	
	
	//Constructor con todos los atributos (menos entregado)
	public Serie(String titulo, int numTempradas, String genero, String creador) {
	this.titulo = titulo;
	this.numTemporadas = numTemporadas;
	this.genero = genero;
	this.creador = creador;
	this.entregado = ENTREGADO_DEF;
	
	}
	
	//Getters
	public String getTitulo() {
		return titulo;
	}
	
	public int getNumTemporadas() {
		return numTemporadas;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public String getCreador() {
		return creador;
	}
	
	//Setters
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setNumTemporadas(int numTemporadas) {
		this.numTemporadas = numTemporadas;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void setCreador(String creador) {
		this.creador = creador;
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
        return this.entregado;
    }

    @Override
    public int compareTo(Object a) {
        if (a instanceof Serie) {
            Serie otra = (Serie) a;
            return Integer.compare(this.numTemporadas, otra.getNumTemporadas());
        }
        return 0;
    }

    // toString
    @Override
    public String toString() {
        return "📺 Serie: " + titulo +
               "\nTemporadas: " + numTemporadas +
               "\nEntregado: " + entregado +
               "\nGénero: " + genero +
               "\nCreador: " + creador + "\n";
    }
}