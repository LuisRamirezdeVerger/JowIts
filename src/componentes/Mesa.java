package componentes;

public class Mesa {

    private int idMesa;
    private Reserva reserva;
    private Cliente cliente;

    public Mesa (int idMesa, Reserva reserva, Cliente cliente){

        this.idMesa = idMesa;
        this.reserva = reserva;
        this.cliente = cliente;
    }

    public void setIdMesa(int newIdMesa){
        this.idMesa = newIdMesa;
    }

    public int getIdMesa(){
        return this.idMesa;
    }

    public void setReserva (Reserva newReserva){
        this.reserva = newReserva;
    }

    public Reserva getReserva(){
        return this.reserva;
    }

    public void setCliente(Cliente newCliente){
        this.cliente = newCliente;
    }

    public Cliente getCliente(){
        return this.cliente;
    }
}
