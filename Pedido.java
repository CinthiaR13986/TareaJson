package pruebamaven;

import java.util.List;
import java.util.Map;

public class Pedido {
	private int id;
	private String fecha;
	private String cliente;
	private List<Map<String, Integer>> Producto;
	public int getId() {
	return id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public String getFecha() {
	return fecha;
	}
	public void setFecha(String fecha) {
	this.fecha = fecha;
	}
	public String getCliente() {
	return cliente;
	}
	public void setCliente(String cliente) {
	this.cliente = cliente;
	}
	public List<Map<String, Integer>> getProductos() {
	return Producto;
	}
	public void setProductos(List<Map<String, Integer>> producto) {
	this.Producto = producto;
	}
	public List<Map<String, Integer>> getProducto() {
		return Producto;
	}
	public void setProducto(List<Map<String, Integer>> producto) {
		Producto = producto;
	}
	}
