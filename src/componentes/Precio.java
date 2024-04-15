package componentes;

public class Precio {

    private int idPrecio, valorPrecio;
    private Producto producto;
    private Proveedor proveedor;
    private String nombreEmpresa;

    public Precio (int idPrecio, int valorPrecio, Producto producto, Proveedor proveedor){

        this.idPrecio = idPrecio;
        this.valorPrecio = valorPrecio;
        this.producto = producto;
        this.proveedor = proveedor;
    }

    public void setIdPrecio(int newIdPrecio){
        this.idPrecio = newIdPrecio;
    }

    public int getIdPrecio(){
        return this.idPrecio;
    }

    public void setValorPrecio(int newValorPrecio){
        this.valorPrecio = newValorPrecio;
    }

    public int getValorPrecio(){
        return this.valorPrecio;
    }

    public void setProducto(Producto newProducto){
        this.producto = newProducto;
    }

    public Producto getProducto(){
        return this.producto;
    }
    
    public void setProveedor(Proveedor newProveedor){
        this.proveedor = newProveedor;
    }

    public Proveedor getProveedor(){
        return this.proveedor;
    }

    public void setNombreEmpresa(String newNombreEmpresa){
        this.nombreEmpresa = newNombreEmpresa;
    }

    public String getNombreEmpresa(){
        return this.nombreEmpresa;
    }

}
