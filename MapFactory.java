public void agregarProducto(String nombreProducto, Map<String, String> inventario, MapString, Integer> coleccionUsuario)
{
    if (inventario.containsKey(nombreProducto)) {
        coleccionUsuario.put(nombreProducto, coleccionUsuario.getOrDefailt(nombreProducto, 0) + 1);
    } else {
        System.out.println("Producto no disponible en el inventario");
    }
}