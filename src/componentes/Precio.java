package componentes;

public class Precio {

    private int idPrecio, valorPrecio;
    private Producto producto;

    public Precio (int idPrecio, int valorPrecio, Producto producto){

        this.idPrecio = idPrecio;
        this.valorPrecio = valorPrecio;
        this.producto = producto;
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

}
