package componentes;

public class Reserva {

    private int idReserva;
    private Cliente cliente;

    public Reserva (int idReserva, Cliente cliente){

        this.idReserva = idReserva;
        this.cliente = cliente;
    }

    public void setIdReserva(int newIdReserva){
        this.idReserva = newIdReserva;
    }
    
    public int getIdReserva(){
        return this.idReserva;
    }

    public void setCliente(Cliente newCliente){
        this.cliente = newCliente;
    }

    public Cliente getCliente(){
        return this.cliente;
    }
}
