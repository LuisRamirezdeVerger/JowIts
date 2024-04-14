package componentes;

public class Inventario {

    //No termino de entender como podemos sacarle provecho a esto, ya que tenemos "cantidadProducto" en "Producto". Hay que verlo ^^
    private int idInventario;
    private Proveedor proveedor;
    private Empresa empresa;

    public Inventario (int idInventario, Proveedor proveedor, Empresa empresa){

        this.idInventario = idInventario;
        this.proveedor = proveedor;
        this.empresa = empresa;
    }

    public void setIdInventario(int newIdInventario){
        this.idInventario = newIdInventario;
    }

    public int getIdInventario(){
        return this.idInventario;
    }

    public void setProveedor(Proveedor newProveedor){
        this.proveedor = newProveedor;
    }

    public Proveedor getProveedor(){
        return this.proveedor;
    }

    public void setEmpresa(Empresa newEmpresa){
        this.empresa = newEmpresa;
    }

    public Empresa getEmpresa(){
        return this.empresa;
    }
}
