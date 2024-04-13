package componentes;

public class Empresa {

    private String CIF;
    private String nombreEmpresa;
    private int numeroEmpleados;

    //numeroEmpleados no está en el constructor para que no sea necesaria añadirlo a la hora de crear el objeto Empresa
    public Empresa(String CIF, String nombreEmpresa){
        
        this.CIF = CIF;
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreEmpresa(){
        return this.nombreEmpresa;
    }

    public void setNombreEmpresa(String newNombreEmpresa){
        nombreEmpresa = newNombreEmpresa;
    }

    public String getCif(){
        return this.CIF;
    }

    public void setCif(String newCIF){
        this.CIF = newCIF;
    }

    public int getNumeroEmpleados(){
        return this.numeroEmpleados;
    }

    public void setNumeroEmpleados(int newNumeroEmpleados){
        this.numeroEmpleados = newNumeroEmpleados;
    }

}
