package pruebamaven;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String Producto = null;

	@SuppressWarnings("hiding")
	public static <Producto> void main(String[] args) throws MalformedURLException {
        @SuppressWarnings("deprecation")
		URL resource = new URL("file:src/main/resources/productos.json");
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto: ");
        pruebamaven.Producto producto;
		producto .setNombre(scanner.nextLine());
        System.out.println("Ingrese la categoria del producto: ");
        producto.setCategoria(scanner.nextLine());
        System.out.println("Ingrese la cantidad del producto: ");
        producto.setCantidad(scanner.nextInt());
        System.out.println("Ingrese el precio del producto: ");
        producto.setPrecio(scanner.nextDouble());
        System.out.println("Ingrese el id del producto: ");
        producto.setId(scanner.nextInt());

        List<pruebamaven.Producto> productosList;
		productosList.add(producto);
        escribirJson(resource,producto);
    }

    public static Root modificarJson(URL resource) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Root productos = objectMapper.readValue(new File(resource.getPath()), Root.class);
            Root producto;
			List<Producto> productoList = Producto.getProducto();
            for (Producto Producto : productoList) {
                System.out.println("Nombre:".concat(Producto.getNombre()).concat(" categoria: ").concat(Producto.getCategoria())
                        .concat(" Cantidad: ").concat(String.valueOf(Producto.getCantidad()))
                        .concat(" Id:").concat(String.valueOf(Producto.getId()))
                        .concat(" Precio: ").concat(String.valueOf(Producto.getPrecio())));
            }
            return productos;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (StreamReadException | DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void escribirJson(URL resource, Root root) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(resource.getFile()), root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}