import java.util.Random;
import java.util.Scanner;
class Estudiante{
    private String nombreEst;
    private int edadEst;
    private Materia materia;
    public Estudiante() {}
    public Estudiante(String nombreEst, int edadEst, Materia materia) {
        this.nombreEst = nombreEst;
        this.edadEst = edadEst;
        this.materia = materia;
    }
    public Materia getMateria() {
        return materia;
    }
    @Override
    public String toString() {
        return "Estudiante{" +
                "nombreEst='" + nombreEst + '\'' +
                ", edadEst=" + edadEst +
                '}';
    }
}
class Materia{
    private double notaACD;
    private double notaAPE;
    private double notaAA;
    private double recuperacion;
    private double notaTotal;
    private String estado;
    private String nombreMateria;
    public Materia() {}
    public Materia(String nombreMateria, double notaACD, double notaAPE, double notaAA) {
        this.notaACD = notaACD;
        this.notaAPE = notaAPE;
        this.notaAA = notaAA;
        this.nombreMateria=nombreMateria;
    }
    public void calcularNotaTotal(){
        this.notaTotal=this.notaACD+this.notaAPE+this.notaAA;
    }
    public String calcularEstado(){
        this.estado = this.notaTotal >=7 ? "APROBADO": "REPROBADO";
        return this.estado;
    }
    public void calcularRecuperacion(){
        this.notaTotal=(this.recuperacion+(this.notaTotal*0.65));
    }
    public double getNotaTotal() {
        return notaTotal;
    }
    public double getRecuperacion() {
        return recuperacion;
    }
    public void setNotaTotal(double notaTotal) {
        this.notaTotal = notaTotal;
    }
    public void setRecuperacion(double recuperacion) {
        this.recuperacion = recuperacion;
    }
    public String getEstado() {
        return estado;
    }
    @Override
    public String toString() {
        return "Materia{" +
                "notaACD=" + notaACD +
                ", notaAPE=" + notaAPE +
                ", notaAA=" + notaAA +
                ", recuperacion=" + recuperacion +
                ", notaTotal=" + notaTotal +
                ", estado='" + estado + '\'' +
                ", nombreMateria='" + nombreMateria + '\'' +
                '}';
    }
}
public class Problema2 {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        Random random= new Random();
        double num1=random.nextDouble();
        double num2=random.nextDouble();
        double num3=random.nextDouble();
        System.out.println("INGRESE: MATERIA");
        Materia materia=new Materia(entrada.next(),num1,num2,num3);
        Estudiante estudiante= new Estudiante("Yasuri Riocaliente",23,materia);
        System.out.println(estudiante);
        materia.calcularNotaTotal();
        materia.calcularEstado();
        materia.setRecuperacion(materia.getEstado().equals("REPROBADO")  ?  3  :  0);
        if (materia.getEstado().equals("REPROBADO")){
            materia.calcularRecuperacion();
        }
        materia.calcularEstado();
        System.out.println(materia);
    }
}