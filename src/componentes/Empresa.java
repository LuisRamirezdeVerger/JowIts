package componentes;

public class Empresa {

    private String CIF;
    //(1) vvv -- static?? -- vvv
    private static String nombreEmpresa;
    private int numeroEmpleados;

    public Empresa(String CIF, String nombreEmpresa, int numeroEmpleados){
        
        this.CIF = CIF;
        Empresa.nombreEmpresa = nombreEmpresa;
        this.numeroEmpleados = numeroEmpleados;
    }

    public static String getNombreEmpresa(){
        //No sé exactamente como hacer ésto. Preguntar!!(1)
        return nombreEmpresa;
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
