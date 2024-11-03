public class Estudiante {
    private String nombre;
    private Estado estado;
    private double nota;
    private double satisfaccion;

    //Construcites
    public Estudiante(String nombre, Estado estado, double nota, double satisfaccion) {
        this.nombre = nombre;
        this.estado = estado;
        this.nota = nota;
        this.satisfaccion = satisfaccion;
    }

    //getters

    public String getNombre() {
        return nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public double getNota() {
        return nota;
    }

    public double getSatisfaccion() {
        return satisfaccion;
    }
}

