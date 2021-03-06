package tp5;

public class Pelicula implements Comparable<Pelicula>{
	private static int identity = 1;
	
	//Atributos
	private final int id;
	private String nombre;
	private Categoria categoria;
	
	Pelicula(String nombre, Categoria categoria)
	{
		this.nombre = nombre;
		this.categoria = categoria;
		this.id = identity++;
	}
	
	public static int devuelveProximoId() 
	{
		return identity; 
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return this.nombre + ". " + this.categoria.nombre + " (#"+ this.id + ")";
	}
	
	@Override
	public int compareTo(Pelicula o) {
		int val = this.nombre.compareTo(o.nombre);
		if(val == 0)
			val = this.categoria.nombre.compareTo(o.categoria.nombre);
		
		return val;
	}
}
