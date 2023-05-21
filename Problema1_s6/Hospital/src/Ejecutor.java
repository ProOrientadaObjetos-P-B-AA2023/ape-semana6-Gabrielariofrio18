import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 class Ciudad {
    private String nombre;
    private String provincia;
     public Ciudad() {}
     public Ciudad(String nombre, String provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }
     public String getNombre() {
         return nombre;
     }
     public void setNombre(String nombre) {
         this.nombre = nombre;
     }
     public String getProvincia() {
         return provincia;
     }
     public void setProvincia(String provincia) {
         this.provincia = provincia;
     }
     @Override
     public String toString() {
         return "Ciudad{" +
                 "nombre='" + nombre + '\'' +
                 ", provincia='" + provincia + '\'' +
                 '}';
     }
 }
class Medico {
    private String nombre;
    private String especialidad;
    private double sueldoMensual;
    public Medico() {}
    public Medico(String nombre, String especialidad, double sueldoMensual) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.sueldoMensual = sueldoMensual;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public double getSueldoMensual() {
        return sueldoMensual;
    }
    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }
    @Override
    public String toString() {
        return "Medico{" +
                "nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", sueldoMensual=" + sueldoMensual +
                '}';
    }
}
 class Enfermero {
    private String nombre;
    private String tipo;
    private double sueldoMensual;
     public Enfermero() {}
     public Enfermero(String nombre, String tipo, double sueldoMensual) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.sueldoMensual = sueldoMensual;
    }
     public String getNombre() {
         return nombre;
     }
     public void setNombre(String nombre) {
         this.nombre = nombre;
     }
     public String getTipo() {
         return tipo;
     }
     public void setTipo(String tipo) {
         this.tipo = tipo;
     }
     public double sueldoMensual() {
         return sueldoMensual;
     }
     public void setSueldoMensual(double sueldoMensual) {
         this.sueldoMensual = sueldoMensual;
     }
     @Override
     public String toString() {
         return "Enfermero{" +
                 "nombre='" + nombre + '\'' +
                 ", tipo='" + tipo + '\'' +
                 ", sueldoMensual=" + sueldoMensual +
                 '}';
     }
 }
 class EntidadHospitalaria {
     private String nombreHospital;
     private Ciudad ciudad;
     private int numeroEspecialidades;
     private List<Medico> listaMedicos;
     private List<Enfermero> listaEnfermeros;
     public EntidadHospitalaria(String nombreHospital, Ciudad ciudad, int numeroEspecialidades) {
         this.nombreHospital = nombreHospital;
         this.ciudad = ciudad;
         this.numeroEspecialidades = numeroEspecialidades;
         this.listaMedicos = new ArrayList<>();
         this.listaEnfermeros = new ArrayList<>();
     }
     public void agregarMedico(Medico medico) {
         listaMedicos.add(medico);
     }
     public void agregarEnfermero(Enfermero enfermero) {
         listaEnfermeros.add(enfermero);
     }
     public double calcularSueldoTotal() {
         double sueldoTotal = 0;
         for (Medico medico : listaMedicos) {
             sueldoTotal += medico.getSueldoMensual();
         }
         for (Enfermero enfermero : listaEnfermeros) {
             sueldoTotal += enfermero.sueldoMensual();
         }
         return sueldoTotal;
     }
     @Override
     public String toString() {
         StringBuilder sb = new StringBuilder();
         sb.append(nombreHospital).append("\n");
         sb.append("Dirección: ").append(ciudad.getNombre()).append("\n");
         sb.append(ciudad.toString()).append("\n");
         sb.append("Número de especialidades: ").append(numeroEspecialidades).append("\n");
         sb.append("Listado de médicos\n\n");
         for (Medico medico : listaMedicos) {
             sb.append(medico.toString()).append("\n");
         }
         sb.append("Listado de enfermeros(as)\n\n");
         for (Enfermero enfermero : listaEnfermeros) {
             sb.append(enfermero.toString()).append("\n");
         }
         sb.append("Total de sueldos a pagar por mes: ").append(calcularSueldoTotal());
         return sb.toString();
     }
 }
 public class Ejecutor {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Ingrese el nombre del hospital:");
         String nombreHospital = scanner.nextLine();
         System.out.println("Ingrese la dirección del hospital:");
         String direccionHospital = scanner.nextLine();
         System.out.println("Ingrese el nombre de la ciudad:");
         String nombreCiudad = scanner.nextLine();
         System.out.println("Ingrese el nombre de la provincia:");
         String nombreProvincia = scanner.nextLine();
         System.out.println("Ingrese el número de especialidades:");
         int numeroEspecialidades = scanner.nextInt();
         scanner.nextLine();
         EntidadHospitalaria hospital = new EntidadHospitalaria(nombreHospital,
                 new Ciudad(nombreCiudad, nombreProvincia), numeroEspecialidades);
         System.out.println("Ingrese la información de los médicos (nombre, especialidad, sueldo mensual):");
         for (int i = 0; i < numeroEspecialidades; i++) {
             System.out.println("Médico " + (i + 1) + ":");
             String nombreMedico = scanner.nextLine();
             String especialidadMedico = scanner.nextLine();
             double sueldoMedico = scanner.nextDouble();
             scanner.nextLine();
             hospital.agregarMedico(new Medico(nombreMedico, especialidadMedico, sueldoMedico));
         }
         System.out.println("Ingrese la información de los enfermeros(as) (nombre, tipo, sueldo mensual):");
         System.out.println("Enfermero 1:");
         String nombreEnfermero = scanner.nextLine();
         String tipoEnfermero = scanner.nextLine();
         double sueldoEnfermero = scanner.nextDouble();
         scanner.nextLine();
         hospital.agregarEnfermero(new Enfermero(nombreEnfermero, tipoEnfermero, sueldoEnfermero));
         System.out.println("Enfermero 2:");
         nombreEnfermero = scanner.nextLine();
         tipoEnfermero = scanner.nextLine();
         sueldoEnfermero = scanner.nextDouble();
         scanner.nextLine();
         hospital.agregarEnfermero(new Enfermero(nombreEnfermero, tipoEnfermero, sueldoEnfermero));
         System.out.println("Enfermero 3:");
         nombreEnfermero = scanner.nextLine();
         tipoEnfermero = scanner.nextLine();
         sueldoEnfermero = scanner.nextDouble();
         scanner.nextLine();
         hospital.agregarEnfermero(new Enfermero(nombreEnfermero, tipoEnfermero, sueldoEnfermero));
         scanner.close();
         System.out.println(hospital.toString());
     }
 }
