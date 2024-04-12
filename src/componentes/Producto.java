package componentes;

public class Producto {

    private int idProducto;
    private int cantidadProducto;
    private int idProveedor;
    private String nombreEmpresa;
    private String fechaRecepcion;
    private String caducidadProducto;

    public Producto(int idProducto, int cantidadProducto, int idProveedor, String nombreEmpresa, String fechaRecepcion, String caducidadProducto){
        this.idProducto = idProducto;
        this.cantidadProducto = cantidadProducto;
        this.idProveedor = idProveedor;
        this.nombreEmpresa = Empresa.getNombreEmpresa();
    }
}