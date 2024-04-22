package componentes;

public class Mesa {

    private int idMesa;
    private int comensales;

    public Mesa (int idMesa, int comensales){

        this.idMesa = idMesa;
        this.comensales = comensales;
    }

    public void setIdMesa(int newIdMesa){
        this.idMesa = newIdMesa;
    }

    public int getIdMesa(){
        return this.idMesa;
    }

    public void setCliente(int newComensales){
        this.comensales = newComensales;
    }

    public int getCliente(){
        return this.comensales;
    }
}
