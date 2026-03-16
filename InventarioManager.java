import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class InventarioManager {

    public void cargarInventario(String archivo, Map<String, String> inventario) {

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            br.readLine(); // saltar encabezado

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split("\\|");

                if (partes.length == 2) {

                    String categoria = partes[0].trim();
                    String producto = partes[1].trim();

                    inventario.put(producto, categoria);
                }
            }

        } catch (IOException e) {
            System.out.println("Error leyendo archivo");
        }
    }

    public void mostrarInventario(Map<String, String> inventario) {

        for (Map.Entry<String, String> entry : inventario.entrySet()) {

            System.out.println(
                    "Producto: " + entry.getKey()
                            + " | Categoria: " + entry.getValue());
        }
    }

    public void agregarProducto(String nombreProducto,
    Map<String, String> inventario,
    Map<String, Integer> coleccionUsuario) {

    if (inventario.containsKey(nombreProducto)) {

        coleccionUsuario.put(
                nombreProducto,
                coleccionUsuario.getOrDefault(nombreProducto, 0) + 1
        );

    } else {

        System.out.println("Producto no disponible en el inventario");
        }
    }

    public void mostrarCategoria(String nombreProducto,
                             Map<String, String> inventario) {

    String categoria = inventario.get(nombreProducto);

    if (categoria != null) {

        System.out.println("Producto: " + nombreProducto +
                ", Categoría: " + categoria);

    } else {

        System.out.println("Producto no encontrado en el inventario");
        }
    }

    public void mostrarColeccionCompleta(Map<String, Integer> coleccionUsuario,
                                     Map<String, String> inventario) {

    System.out.println("Coleccion actual");

    for (String producto : coleccionUsuario.keySet()) {

        String categoria = inventario.get(producto);
        int cantidad = coleccionUsuario.get(producto);

        System.out.println(producto +
                " | " + categoria +
                " | cantidad: " + cantidad);
    }
}
}