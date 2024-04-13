package componentes;

public class Empleado {

    private int idEmpleado;
    private String nombreEmpleado, dniEmpleado, turnoEmpleado;
    private int sueldoEmpleado;
    //Le incluimos objetos de la clase Categoria/Empresa para poder referenciarlos.
    private Categoria categoria;
    private Empresa empresa;

    public Empleado (int idEmpleado, String nombreEmpleado, String dniEmpleado, String turnoEmpleado, int sueldoEmpleado, Categoria categoria, Empresa empresa){

        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.dniEmpleado = dniEmpleado;
        this.turnoEmpleado = turnoEmpleado;
        this.sueldoEmpleado = sueldoEmpleado;
        this.categoria = categoria;
        this.empresa = empresa;
    }

    public int getIdEmpleado(){
        return this.idEmpleado;
    }

    public void setIdEmpleado (int newIdEmpleado){
        this.idEmpleado = newIdEmpleado;
    }

    public String getNombreEmpleado(){
        return this.nombreEmpleado;
    }

    public void setNombreEmpleado (String newNombreEmpleado){
        this.nombreEmpleado = newNombreEmpleado;
    }

    public String getDniEmpleado(){
        return this.dniEmpleado;
    }
    
    public void setDniEmpleado(String newDniEmpleado){
        this.dniEmpleado = newDniEmpleado;
    }

    public String getTurnoEmpleado(){
        return this.turnoEmpleado;
    }

    public void setTurnoEmpleado(String newTurnoEmpleado){
        this.turnoEmpleado = newTurnoEmpleado;
    }

    public int getSueldoEmpleado(){
        return this.sueldoEmpleado;
    }

    public void setSueldoEmpleado(int newSueldoEmpleado){
        this.sueldoEmpleado = newSueldoEmpleado;
    }

    public Categoria getCategoria(){
        return this.categoria;
    }

    public void setCategoria (Categoria newCategoria){
        this.categoria = newCategoria;
    }

    public Empresa getEmpresa(){
        return this.empresa;
    }

    public void setEmpresa(Empresa newEmpresa){
        this.empresa = newEmpresa;
    }
}
