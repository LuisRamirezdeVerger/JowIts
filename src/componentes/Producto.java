package componentes;

public class Producto {

    private int idProducto, cantidadProducto;
    private String fechaRecepcion, caducidadProducto;
    private Proveedor proveedor;
    /* Podríamos añadir "estado" y que cambie de color el fondo de la imagen del producto si la caducidad está cercana o algo así,
    pero me parece algo más "late" */

    public Producto(int idProducto, int cantidadProducto, String fechaRecepcion, String caducidadProducto, Proveedor proveedor){
        this.idProducto = idProducto;
        this.cantidadProducto = cantidadProducto;
        this.fechaRecepcion = fechaRecepcion;
        this.caducidadProducto = caducidadProducto;
        this.proveedor = proveedor;
    }

    public void setIdProducto(int newIdProducto){
        this.idProducto = newIdProducto;
    }

    public int getIdProducto(){
        return this.idProducto;
    }

    public void setCantidadProducto(int newCantidadProducto){
        this.cantidadProducto = newCantidadProducto;
    }

    public int getCantidadProducto(){
        return this.cantidadProducto;
    }

    public void setFechaRecepcion(String newFechaRecepcion){
        this.fechaRecepcion = newFechaRecepcion;
    }

    public String getFechaRecepcion(){
        return this.fechaRecepcion;
    }

    public void setCaducidadProducto(String newCaducidadProducto){
        this.caducidadProducto = newCaducidadProducto;
    }

    public String getCaducidadProducto(){
        return this.caducidadProducto;
    }

    public void setProveedor(Proveedor newProveedor){
        this.proveedor = newProveedor;
    }

    public Proveedor getProveedor(){
        return this.proveedor;
    }

}