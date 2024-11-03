import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Academia academia = new Academia();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("""
        \nMenú de opciones:
        1. Agregar estudiante
        2. Generar informe de KPIs
        3. Salir
        Seleccione una opción: 
        """);
            int opcion = scanner.nextInt();

            switch (opcion){
                case 1://se evalua el valor de opcion
                    scanner.nextLine();// es para limpiar la entrada de datos
                    System.out.println("Nombre del estudiante");
                    String nombre = scanner.nextLine(); //almacena la entrada en nombre

                    System.out.println("Estado (1: Aprobado, 2: Reprobado, 3: Desertado"); // se imprime el estado del estudiante
                    int estadoInt = scanner.nextInt();

                    //se convierte el esdoint a una especio de enum y siempre se asigna al tipo de estado
                    Estado estado = switch (estadoInt){
                        case 1 -> Estado.APROBADO;
                        case 2 -> Estado.REPROBADO;
                        case 3 -> Estado.DESERTADO;
                        default -> throw  new IllegalArgumentException("estado no valido");// es para evitar errores en el codigo si ingrese otro dato
                    };
                    // se pide que ingrese la nota y se almacena en nota
                    System.out.println("Nota del estudiante: ");
                    double nota = scanner.nextDouble();
                        //se pide la satisfaccion
                    //
                    System.out.println("Satisfacción (entre 0 y 5): ");
                    double satisfaccion = scanner.nextDouble();
                    while (satisfaccion<0||satisfaccion>5){//la entrada de dato tiene que ser mayot de 0 a 5 para que el bucle continue
                        //si el rango no esta adentro de 0 a 5 el bucle se corre una vez mas
                        System.out.println("La satisfaccion debe estar entre 0 y 5. Ingrese nuevamente: "); // para recordar que debe estar en 0y5
                        satisfaccion = scanner.nextDouble(); // para verificar que ingreso bien la entrada
                    }

                    //crear y agregar estudiantes
                    // se crea un nuevo objeto o una instacion de la clase estudiante
                    //el constructor toma de parametros nombre, estado, nota, y satisfaccion

                    Estudiante estudiante =new Estudiante(nombre, estado, nota, satisfaccion);
                    academia.agregarEstudiante(estudiante);// se encargar para almacenar el objeto nuevo
                    //para indicar que es con exito
                    System.out.println("Estudiante agregado con exito");
                    break;
                case 2:
                    academia.generarInformeKPIs();// se muestra el general informes
                    //como la tasa de aprobacion y la tasa de desercion
                    break;//salir del swich

                case 3:
                    System.out.println("Saliendo del programa");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opcion no valida");


            }
        }
    }
}