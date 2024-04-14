package componentes;

public class Cliente {

    private int idCliente;
    private String nombreCliente, telefonoCliente, dniCliente;
    

    public Cliente (int idCliente, String nombreCliente, String telefonoCliente, String dniCliente){

        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.dniCliente = dniCliente;
    }

    public int getIdCliente(){
        return this.idCliente;
    }

    public void setIdCliente(int newIdCliente){
        this.idCliente = newIdCliente;
    }

    public String getNombreCliente(){
        return this.nombreCliente;
    }

    public void setNombreCliente(String newNombreCliente){
        this.nombreCliente = newNombreCliente;
    }

    public String getTelefonoCliente(){
        return this.telefonoCliente;
    }

    public void setTelefonoCliente(String newTelefonoCliente){
        this.telefonoCliente = newTelefonoCliente;
    }

    public String getDniCliente(){
        return this.dniCliente;
    }

    public void setDniCliente(String newDniCliente){
        this.dniCliente = newDniCliente;
    }
}
