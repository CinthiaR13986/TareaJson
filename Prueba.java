package pruebamaven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Prueba {
	@SuppressWarnings({ "unused", "hiding" })
	public static <Producto> void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader  archivo;
		Gson gson = new Gson();
		try {
		archivo = new FileReader("/home/lfac/promocional.json");
		@SuppressWarnings("unchecked")
		Map<String, Object> data = gson.fromJson(archivo, Map.class);
		List<Producto> Producto =
		gson.fromJson(data.get("productos").toString(), new TypeToken<List<Producto>>()
		{}.getType());
		//List<Cliente> clients =
		gson.fromJson(data.get("clientes").toString(), new TypeToken<List<Cliente>>()
		{}.getType());
		//List<Proveedor> Proveedor =
		gson.fromJson(data.get("proveedores").toString(), new TypeToken<List<Proveedor>>()
		{}.getType());
		List<Producto> Pedido =
		gson.fromJson(data.get("pedidos").toString(), new TypeToken<List<Pedido>>()
		{}.getType());
		} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}

}
