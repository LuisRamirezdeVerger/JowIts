package componentes;

public class Inventario {

    private int idInventario, idProveedor;
    private String nombreEmpresa;

    public Inventario (int idInventario, int idProveedor, String nombreEmpresa){

        this.idInventario = idInventario;
        this.idProveedor = idProveedor;
        this.nombreEmpresa = nombreEmpresa;
    }
}
