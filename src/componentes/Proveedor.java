package componentes;

public class Proveedor {

    private int idProveedor;
    private String nombreProveedor, CIFProveedor;

    public Proveedor (int idProveedor, String nombreProveedor, String CIFProveedor){
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.CIFProveedor = CIFProveedor;
    }

    public void setIdProveedor(int newIdProveedor) {
        this.idProveedor = newIdProveedor;
    }

    public int getIdProveedor(){
        return this.idProveedor;
    }

    public void setNombreProveedor(String newNombreProveedor){
        this.nombreProveedor = newNombreProveedor;
    }

    public String getNombreProveedor(){
        return this.nombreProveedor;
    }

    public void setCIFProveedor(String newCIFProveedor){
        this.CIFProveedor = newCIFProveedor;
    }

    public String getCIFProveedor(){
        return this.CIFProveedor;
    }
 
}
