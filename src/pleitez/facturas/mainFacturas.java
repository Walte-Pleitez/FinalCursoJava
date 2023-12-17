package pleitez.facturas;

import java.util.Scanner;
import java.text.SimpleDateFormat;

public class mainFacturas {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setIdCliente("12345");
		cliente.setNombreCliente("Walter");
		
		Scanner input = new Scanner(System.in);
        System.out.print("Ingrese una descripcion de la factura: ");
        String desc = input.nextLine();
        Factura factura = new Factura(desc, cliente);

        Producto producto;

        System.out.println();

        for(int i = 0; i<3; i++){
            producto = new Producto();
            System.out.print("Ingrese nombre producto " + producto.getIdProducto() + ": ");
            producto.setNombre(input.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(input.nextFloat());

            System.out.print("Ingrese la cantidad: ");
            factura.addItemFactura(new ItemFactura(input.nextInt(), producto));

            System.out.println();
            input.nextLine();
        }
        System.out.println(factura);
	}
}
