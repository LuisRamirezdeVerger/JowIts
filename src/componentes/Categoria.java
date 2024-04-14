package componentes;

public class Categoria {

    private int idCategoria;
    private String nombreCategoria;

    public Categoria (int idCategoria, String nombreCategoria){

        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdCategoria(){
        return idCategoria;
    }

    public void setIdCategoria(int newIdCategoria){
        this.idCategoria = newIdCategoria;
    }

    public String getNombreCategoria(){
        return nombreCategoria;
    }

    public void setNombreCategoria(String newNombreCategoria){
        this.nombreCategoria = newNombreCategoria;
    }
}
