package componentes;

public class Menu {

    private int idMenu;
    private Cliente cliente;
    
    public Menu (int idMenu,Cliente cliente ){

        this.idMenu = idMenu;
        this.cliente = cliente;
    }

    public void setIdMenu(int newIdMenu){
        this.idMenu = newIdMenu;
    }

    public int getIdMenu(){
        return this.idMenu;
    }

    public void setCliente(Cliente newCliente){
        this.cliente = newCliente;
    }

    public Cliente getCliente(){
        return this.cliente;
    }
}
