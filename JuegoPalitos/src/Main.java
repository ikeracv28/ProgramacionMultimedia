import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opciones = 0;
        int modo = 0;
        //Menu menu = new Menu();

        //While para que el menu se repita hasta que el usuario le de al 3 para salir
        while (opciones != 3) {
           // menu.menu();
            System.out.println("1. Jugar");
            System.out.println("2. Controles / Ayuda");
            System.out.println("3. Salir");
            System.out.println("Elige una opción: ");
            try {
                opciones = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opciones = 0;
            }

            // Switch para las opciones del menu
            switch (opciones) {
                case 1:
                    while(modo!=3){
                       // Menu.menuJugar();

                        System.out.println("1. Jugador vs Jugador");
                        System.out.println("2. Jugador vs IA");
                        System.out.println("3. Volver al menú principal");
                        System.out.println("Elige un modo de juego: ");
                        try{
                            modo = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e){
                            modo = 0;
                        }
                        switch (modo) {
                            case 1:
                        }

                        //rengo que implementar primero los metodos de juego
                    }
                    Juego juego = new Juego();
                    juego.juegoVsJugador(scanner);// Pasamos el scanner al metodo juego
                    break;
                case 2:
                    System.out.println("Controles / Ayuda:");
                    System.out.println("El objetivo del juego es no ser el jugador que se quede con el último palito.");
                    System.out.println("En cada turno, puedes quitar entre 1 y 4 palitos.");
                    System.out.println("Después de tu turno, la máquina quitará entre 1 y 4 palitos, de manera que la suma de los palitos que quitan ambos jugadores sea 5.");
                    System.out.println("Si te quedas con el último palito, pierdes.");
                    break;
                case 3:
                    System.out.println("Saliendo del juego. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
            }
        }

    }
}