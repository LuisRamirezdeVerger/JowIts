package componentes;

public class Producto {

    private int idProducto;
    private int cantidadProducto;
    private int idProveedor;
    private String nombreEmpresa;
    private String fechaRecepcion;
    private String caducidadProducto;
    /*Podríamos añadir "estado" y que cambie de color el fondo de la imagen del producto o algo así,
    pero me parece algo más "late" */

    //Elimino nombreEmpresa para que no sea necesario añadirlo a la hora de crear un producto
    public Producto(int idProducto, int cantidadProducto, int idProveedor, String fechaRecepcion, String caducidadProducto){
        this.idProducto = idProducto;
        this.cantidadProducto = cantidadProducto;
        this.idProveedor = idProveedor;
        this.fechaRecepcion = fechaRecepcion;
        this.caducidadProducto = caducidadProducto;
    }

    public void setIdProducto(int newIdProducto){
        this.idProducto = newIdProducto;
    }

    public int getIdProducto(){
        return this.idProducto;
    }
}