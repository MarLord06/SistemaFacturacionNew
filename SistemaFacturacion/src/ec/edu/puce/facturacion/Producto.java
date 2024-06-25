package ec.edu.puce.facturacion;

public class Producto {
	private Integer id = 0;
	private String articulo_nombre;
	private Float precio;
	private Integer stock;
	private String descripcion;
	private static Integer idSiguiente = 1;

	public String getId() {
		return id.toString();
	}
	

	public void setid() {
		this.id = idSiguiente;
		idSiguiente += 1;
	}
	
	public void setStock(String stock) {
		this.stock = Integer.parseInt(stock);
	}
	
	public String getStock() {
		return stock.toString();
	}

	public String getArticulo_nombre() {
		return articulo_nombre;
	}

	public void setArticulo_Nombre(String articulo_nombre) {
		this.articulo_nombre = articulo_nombre;
	}
	

	public String getPrecio() {
		return precio.toString();
	}
	
	public void setPrecio(String precio){
		this.precio = Float.parseFloat(precio);
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	@Override
	public String toString() {
	    return articulo_nombre; // Devuelve el nombre del producto como String
	}

}
