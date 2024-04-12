package componentes;

public class Empresa {

    private String cif;
    private String nombreEmpresa;
    private int numeroEmpleados;

    public  Empresa(String cif, String nombreEmpresa, int numeroEmpleados){
        
        this.cif = cif;
        this.nombreEmpresa = nombreEmpresa;
        this.numeroEmpleados = numeroEmpleados;
    }

    public static String getNombreEmpresa(){
        return this.nombreEmpresa;
    }

}
