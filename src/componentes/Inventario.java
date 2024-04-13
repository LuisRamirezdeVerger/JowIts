package componentes;

public class Inventario {

    //No termino de entender como podemos sacarle provecho a esto, ya que tenemos "cantidad producto". Hay que verlo ^^
    private int idInventario, idProveedor;
    private String nombreEmpresa;

    public Inventario (int idInventario, int idProveedor, String nombreEmpresa){

        this.idInventario = idInventario;
        this.idProveedor = idProveedor;
        this.nombreEmpresa = nombreEmpresa;
    }
}
