Public void mostrarCategoria(String nombreProducto, Map<String, String> inventario) {
    String categoria = inventario.get(nombreProducto);
    if (categoria != null) {
        System.out.println("Producto: " + nombreProducto + ", Categoría: " + categoria);
    } else {
        System.out.println("Producto no encontrado en el inventario");
    }
}