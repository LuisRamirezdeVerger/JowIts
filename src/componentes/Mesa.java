package componentes;

public class Mesa {

    private int idMesa;
    private Cliente cliente;

    public Mesa (int idMesa, Cliente cliente){

        this.idMesa = idMesa;
        this.cliente = cliente;
    }

    public void setIdMesa(int newIdMesa){
        this.idMesa = newIdMesa;
    }

    public int getIdMesa(){
        return this.idMesa;
    }

    public void setCliente(Cliente newCliente){
        this.cliente = newCliente;
    }

    public Cliente getCliente(){
        return this.cliente;
    }
}
