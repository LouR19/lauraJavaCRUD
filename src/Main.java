import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello world!");

        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int opcion;
        do {
            System.out.println(".....Inventario.....\n1. => Agregar.\n2. => Mostrar.\n3. => Actualizar.\n4. => Borrar.\n5. => Salir\nElija una opción:");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese nombre del producto:");
                    String nombre = scanner.next();
                    System.out.println("Ingrese cantidad del producto:");
                    int stock = Integer.parseInt(scanner.next());
                    System.out.println("Ingrese precio del producto:");
                    float precio = Float.parseFloat(scanner.next());
                    Producto nuevoProducto = new Producto(nombre, stock, precio);
                    inventario.agregarProducto(nuevoProducto);

                    break;
                case 2:
                    inventario.mostrarProductos();
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del producto a actualizar:");
                    String Actualizar = scanner.next();
                    inventario.actualizarProducto(Actualizar);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del producto a borrar:");
                    String Borrar = scanner.next();
                    inventario.eliminarProducto(Borrar);
                    break;
                case 5:
                    System.out.println("Estas seguro que deseas salir? 1-Si / 2-No");
                    int opc = scanner.nextInt();
                    if (opc == 1) {
                        System.out.println("Saliendo...");
                        break;
                    }else {
                        opcion = 0;
                    }
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }
}