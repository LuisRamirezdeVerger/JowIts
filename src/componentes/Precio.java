package componentes;

public class Precio {

    private int idPrecio, valorPrecio, idProducto, idProveedor;
    private String nombreEmpresa;

    public Precio (int idPrecio, int valorPrecio, int idProducto, int idProveedor, String nombreEmpresa){

        this.idPrecio = idPrecio;
        this.valorPrecio = valorPrecio;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.nombreEmpresa = nombreEmpresa;
    }
}
