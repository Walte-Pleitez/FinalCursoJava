package pleitez.facturas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
	private int folio;
	private String detalle;
	private Date fecha;
	private Cliente cliente;
	private ItemFactura[] items;
	private int indiceItems;
	public static final int MAX_ITEMS = 10;
    private static int ultimoFolio;
	
	

	public Factura(String detalle, Cliente cliente) {
		this.folio = ++ultimoFolio;
		this.detalle = detalle;
		this.fecha = new Date();
		this.cliente = cliente;
		this.items = new ItemFactura[MAX_ITEMS];
	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIndiceItems() {
		return indiceItems;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public ItemFactura[] getItems() {
		return items;
	}
	public void addItemFactura(ItemFactura item) {
        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }
	public float calcularTotal() {
        float total = 0.0f;
        for (ItemFactura item : this.items) {
            if (item == null) {
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }
	public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura Num: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombreCliente())
                .append("\t Id: ")
                .append(cliente.getIdCliente())
                .append("\nDescripcion: ")
                .append(this.detalle)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha Emision: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#   Nombre     $   Cant.   Total\n");

        for(ItemFactura item: this.items){
            if(item == null){
                continue;
            }
            sb.append(item)
                    .append("\n");
        }
        sb.append("\nGran Total: ")
                .append(calcularTotal());

        return sb.toString();
    }

	@Override
	public String toString() {
		return this.generarDetalle();
	}
	
	
}
