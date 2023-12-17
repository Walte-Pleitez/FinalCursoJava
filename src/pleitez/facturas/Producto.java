package pleitez.facturas;

public class Producto {
	private int idProducto;
	private String nombre;
	private double precio;
	private static int correlativo;
	
	public Producto() {
		this.idProducto = ++correlativo;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return idProducto + "  " +         nombre + "  " + precio;
	}
	
	
}
