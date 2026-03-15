public void mostrarColeccionCompleta(Map<String, Integer> coleccionUsuario, Map<String, String> inventario) {
    System.out.println("coleccion actual");
    for (String producto : coleccionUsuario.keySet()) {
        String categoria = inventario.get(producto);
        int cantidad = coleccionUsuario.get(producto);
        System.out.println("producto" + producto + "categoria" + categoria + "cantidad" + cantidad);
    }
}