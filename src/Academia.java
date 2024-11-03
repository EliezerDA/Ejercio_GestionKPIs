import java.util.ArrayList;
import java.util.List;

public class Academia {
    //Lista para almacenar los estudiantes de la academia
    private List<Estudiante> estudiantes;
//constructor de la clase
    public Academia() {
        this.estudiantes = new ArrayList<>();
    }

    // Metodo para agregar estudiante
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    //metodo para calcular la tasa de aprobados
    public double calcularTasaAprobacion() {
        int aprobados = 0;
        //recorer la lista de estudiantes y cuantos los aprobados
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getEstado() == Estado.APROBADO) {// permite contar cuantos estudiantes estan aprobados
                aprobados++;
            }
        }
        return (double) aprobados / estudiantes.size();// es .size es un metodo para obtener los elementos de un ArrayList
    }//aprovados es un int asi que lo converte a double para que me de un resultado  decimal

    public double calcularTasaDesercion(){// se declara el metodo y retorna un valor double
        int desertados=0;// es la cantida de estudiantes que han desertado y se inicializa en o
        for (Estudiante estudiante : estudiantes){ //aqui se recorre cada Estudiante
            if (estudiante.getEstado() == Estado.APROBADO){ // es para verificar si el estudiante es DESETADO y si es desertado se hacer un incremento en 1
                desertados++;
            }
        }// se calcula la tasa de desercion en porcentaje
        return (double) desertados/estudiantes.size()*100;// se cambia el int a double para que da un resultado correcto
        // /estudiantes.size()*100 se divide la cantidad de estiantes por el numero total de estudiantes y se multiplica en 100
    }

    //metodo para calcular el promedio de satisfaccion
    public double calcularPromedioSatisfacion(){
        double sumaSatisfacion=0;
        // se suma la satisfacion de todos los estudiantes
        for (Estudiante estudiante: estudiantes){
            sumaSatisfacion += estudiante.getSatisfaccion();
        }//se calcula el promedio de estudiantes en la satifaccion
        return estudiantes.isEmpty()? 0.0 : sumaSatisfacion / estudiantes.size();
    }
    //metodos para general el informe kpis
        public void generarInformeKPIs(){//formatea el texto con las metricas
            String informe = String.format("""
            Informe de KPIs:
            Tasa de aprobación: %.2f%% 
            Tasa de deserción: %.2f%% 
            Promedio de satisfacción: %.2f 
            Total de estudiantes inscritos: %d
            """,    calcularTasaAprobacion(),//calcula y devuelve la tasa de aprobacion como porcentaje
                    calcularTasaDesercion(),    // este tambien
                    calcularPromedioSatisfacion(),
                    estudiantes.size()//devuelve el numero total de estudiantes en la lista estudiantes
            );
            System.out.println(informe);
        }



}


