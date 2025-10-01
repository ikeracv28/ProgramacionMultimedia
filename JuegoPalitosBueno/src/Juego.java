import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Juego {
    static Scanner scanner = new Scanner(System.in);



    static void jugadorVsJugador(){
        int palitos = 21;
        int turno= 1;
        while(true){
            try{
                System.out.println("Turno del jugador " + turno);
                System.out.println("¿Cuantos palitos quieres tachar?: ");
                mostrarPalito(palitos);
                int jugada = scanner.nextInt();

                if(jugada > 4 || jugada <= 0){
                    System.out.println("No puede quitar mas de 4 palitos Y al menos 1");
                } else {
                    palitos -= jugada;
                }
                if (palitos == 0) {
                    System.out.println("Has perdido");
                    System.out.println("Deseas reinciar la partida o volver al menu? Pulsa R paara reiniciar o M para ir al menu: ");
                    String volverR  = scanner.next();
                    if(volverR.equals("R")){
                        palitos = 21;
                        jugadorVsJugador();
                        return;

                    }else if(volverR.equals("M")){
                        return;
                    }

                }

                turno = (turno == 1) ? 2 : 1;

            }catch(InputMismatchException e){
                System.out.println("No puedes introducir letras");
            }
        }
    }

    static void jugadorVsIA(){
        int palitos = 21;
        int turno = 1;
        while(true){
            try{
                if(turno == 1) {
                    System.out.println("Turno del jugador " + turno);
                    System.out.println("¿Cuantos palitos quieres tachar?: ");
                    mostrarPalito(palitos);
                    int jugada = scanner.nextInt();

                    if (jugada > 4 || jugada <= 0) {
                        System.out.println("No puede quitar mas de 4 palitos Y al menos 1");
                    } else {
                        palitos -= jugada;
                    }
                    if (palitos == 0) {
                        System.out.println("Has perdido");
                        break;
                    }
                    turno = 2;
                }else{
                    System.out.println("Turno de la IA");

                    System.out.println("¿Cuantos palitos quieres tachar?: ");
                    mostrarPalito(palitos);
                    int jugadaIA = (int) (Math.random() * 4) + 1;

                    palitos -= jugadaIA;

                    if (palitos == 0) {
                        System.out.println("La IA ha perdido");
                        break;
                    }
                    turno = 1;
                }

            }catch(InputMismatchException e){
                System.out.println("No puedes introducir letras");
            }
        }
    }


    static void controlesReglas(){
        System.out.println("Controles / Ayuda:");
        System.out.println("El objetivo del juego es no ser el jugador que se quede con el último palito.");
        System.out.println("En cada turno, puedes quitar entre 1 y 4 palitos.");
        System.out.println("Después de tu turno, la máquina quitará entre 1 y 4 palitos, de manera que la suma de los palitos que quitan ambos jugadores sea 5.");
        System.out.println("Si te quedas con el último palito, pierdes.");
    }

    static void mostrarPalito(int palitos){
        for(int i = 0; i < palitos; i++){
            System.out.print("|");
        }
        System.out.println();
    }
}
