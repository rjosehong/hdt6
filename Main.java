import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione implementación de Map");
        System.out.println("1 HashMap");
        System.out.println("2 TreeMap");
        System.out.println("3 LinkedHashMap");

        int tipo = scanner.nextInt();
        scanner.nextLine();

        Map<String, String> inventario = MapFactory.crearMap(tipo);
        Map<String, Integer> coleccionUsuario = new HashMap<>();

        InventarioManager manager = new InventarioManager();

        manager.cargarInventario("inventario.txt", inventario);

        int opcion = 0;

        while (opcion != 7) {

            System.out.println("\nMENU");
            System.out.println("1 Agregar producto");
            System.out.println("2 Mostrar categoria");
            System.out.println("3 Mostrar coleccion");
            System.out.println("4 Mostrar coleccion ordenada");
            System.out.println("5 Mostrar inventario");
            System.out.println("6 Mostrar inventario ordenado");
            System.out.println("7 Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("Ingrese producto:");
                    String producto = scanner.nextLine();

                    manager.agregarProducto(producto, inventario, coleccionUsuario);
                    break;

                case 2:

                    System.out.println("Ingrese producto:");
                    String p = scanner.nextLine();

                    manager.mostrarCategoria(p, inventario);

                    break;

                case 3:

                    manager.mostrarColeccionCompleta(coleccionUsuario, inventario);

                    break;

                case 4:

                    coleccionUsuario.entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByKey())
                            .forEach(entry -> {

                                String prod = entry.getKey();
                                int cant = entry.getValue();
                                String cat = inventario.get(prod);

                                System.out.println(prod +
                                        " | " + cat +
                                        " | " + cant);
                            });

                    break;

                case 5:
                    long inicio = System.nanoTime();

                    manager.mostrarInventario(inventario);

                    long fin = System.nanoTime();

                    long tiempo = fin - inicio;

                    System.out.println("Tiempo de ejecución: " + tiempo + " nanosegundos");

                    break;

                case 6:

                    inventario.entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue())
                            .forEach(entry ->

                                    System.out.println(
                                            entry.getKey() +
                                                    " | " +
                                                    entry.getValue())
                            );

                    break;
            }
        }

        scanner.close();
    }
}