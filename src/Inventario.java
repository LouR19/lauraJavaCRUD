import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventario {
    private final List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.add(producto);
        } else {
            System.out.println("Error: No se puede agregar un producto nulo.");
        }
    }
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Productos:");
            for (Producto producto : productos) {
                System.out.println(producto.toString());
            }
        }
    }

    public void actualizarProducto(String nombre) {
        Scanner scanner = new Scanner(System.in);
        for (Producto producto : productos) {
            int opc = 0;
            do {
                if (producto.getNombre().equals(nombre)) {
                    ///System.out.println("Ingrese la nueva cantidad del producto:");
                    ///int nuevaCantidad = Integer.parseInt(scanner.nextLine());
                    ///System.out.println("Desea actualizar el precio? si");
                    System.out.println("Actualizar Producto:\n 1 => Cantidad\n 2 => Precio\n 3 => Cantidad y Precio\n4 => Salir");
                    opc = scanner.nextInt();
                    if (opc == 1) {
                        scanner.nextLine();
                        System.out.println("Ingrese la nueva cantidad del producto:");
                        int nuevaCantidad = Integer.parseInt(scanner.nextLine());
                        producto.setStock(nuevaCantidad);
                        System.out.println("Producto actualizado correctamente.");
                        return;
                    } else if (opc == 2) {
                        scanner.nextLine();
                        System.out.println("Ingrese el nuevo precio del producto:");
                        float nuevoPrecio = Float.parseFloat(scanner.nextLine());
                        producto.setPrecio(nuevoPrecio);
                        System.out.println("Producto actualizado correctamente.");
                        return;
                    } else if (opc == 3) {
                        scanner.nextLine();
                        System.out.println("Ingrese la nueva cantidad del producto:");
                        int nuevaCantidad = Integer.parseInt(scanner.nextLine());
                        System.out.println("Ingrese el nuevo precio del producto:");
                        float nuevoPrecio = Float.parseFloat(scanner.nextLine());
                        producto.setStock(nuevaCantidad);
                        producto.setPrecio(nuevoPrecio);
                        System.out.println("Producto actualizado correctamente.");
                        return;
                    } else {
                        System.out.println("Estas seguro que deseas salir? 1-Si / 2-No");
                        int opcion = scanner.nextInt();
                        if (opcion == 1) {
                            System.out.println("Saliendo...");
                            return;
                        } else if (opcion == 2) {
                            opc = 0;
                        }else {
                            System.out.println("Opción inválida.");
                        }
                    }
                }
            }while (opc != 4);

        }
        System.out.println("Error: El producto no existe en el inventario.");
    }

    public void eliminarProducto(String nombre) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(nombre)) {
                productos.remove(i);
                System.out.println("Producto eliminado correctamente.");
                return;
            }
        }
        System.out.println("Error: El producto no existe en el inventario.");
    }
}