import java.util.Scanner;
import java.util.Random;

public class Juego {

    // metodo para juador vs jugador
    public void juegoVsJugador(Scanner scanner) {
        boolean salir = false;
        while (!salir) {
            int palitos = 21;
            int turno = 1;
            boolean partidaTerminada = false;

            while (palitos > 1 && !partidaTerminada) {
                System.out.println("\nTurno del jugador " + turno);
                for (int i = 0; i < palitos; i++) System.out.println("|");
                System.out.println("\nQuedan " + palitos + " palitos.");
                System.out.print("¿Cuántos palitos quieres quitar (1-4)? (R para reiniciar, M para ir al menú): ");
                String entrada = scanner.nextLine().toUpperCase();

                if (entrada.equals("R")) {
                    System.out.println("Reiniciando partida ");
                    partidaTerminada = true;
                    continue;
                }
                if (entrada.equals("M")) {
                    System.out.println("Volviendo al menú ");
                    salir = true;
                    partidaTerminada = true;
                    continue;
                }
                int jugada;
                try {
                    jugada = Integer.parseInt(entrada);
                    if (jugada < 1 || jugada > 4 || jugada >= palitos) {
                        System.out.println("Jugada no válida.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Eso no es un número válido.");
                    continue;
                }
                palitos -= jugada;
                if (palitos == 1) {
                    System.out.println("¡El jugador " + turno + " ha perdido!!!");
                    System.out.println("Pulsa R para reiniciar o M para volver al menú.");
                    while (true) {
                        String fin = scanner.nextLine().toUpperCase();
                        if (fin.equals("R")) {
                            partidaTerminada = true;
                            break;
                        } else if (fin.equals("M")) {
                            salir = true;
                            partidaTerminada = true;
                            break;
                        } else {
                            System.out.println("Opción no válida. Pulsa R para reiniciar o M para volver al menú.");
                        }
                    }
                }
                turno = (turno == 1) ? 2 : 1; // Cambiar de jugador, si es 1 pasa a 2 y si es 2 pasa a 1
            }
        }
    }

    // metodo para jugar con la IA
    public void jugarVsIA(Scanner scanner){
        boolean salir = false;
        Random random = new Random();
        //Este va a ser el bucle para reiniciar la partida si se pulsa la R
        while(!salir){
            int palitos = 21;
            boolean partidaTerminada = false;

            while(palitos > 1 && !partidaTerminada) {
                // turno de jugador
                // mostrar palitos y turno
                System.out.println("\nTurno del jugador");
                for (int i = 0; i < palitos; i++) System.out.print("|");
                System.out.println("\nQuedan " + palitos + " palitos.");
                System.out.print("¿Cuántos palitos quieres quitar (1-4)? (R para reiniciar, M para ir al menú): ");

                String entrada = scanner.nextLine().toUpperCase();

                // Comprobar si el usuario quiere reiniciar o volver al menu
                if (entrada.equals("R")) {
                    System.out.println("Reiniciando partida ");
                    partidaTerminada = true; // Salimos del bucle de la partida, pero no del bucle del menu
                    continue; // Volvemos al inicio del bucle para reiniciar la partida
                }
                if (entrada.equals("M")) {
                    System.out.println("Volviendo al menú ");
                    salir = true; // Salimos del bucle del menu
                    partidaTerminada = true; // Salimos del bucle de la partida
                    continue; // Salimos del bucle de la partida
                }

                int jugada;
                // controlar que la jugada sea valida
                try {
                    jugada = Integer.parseInt(entrada);
                    if (jugada < 1 || jugada > 4 || jugada >= palitos) {
                        System.out.println("Jugada no válida.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Eso no es un número válido.");
                    continue;
                }
                palitos -= jugada;
                if (palitos == 1) {
                    System.out.println("¡Has perdido!!!");
                    System.out.println("Pulsa R para reiniciar o M para volver al menú.");
                    while(true){
                        String fin = scanner.nextLine().toUpperCase();
                        if(fin.equals("R")){
                            partidaTerminada = true;
                            break;
                        } else if(fin.equals("M")){
                            salir = true;
                            partidaTerminada = true;
                            break;
                        } else{
                            System.out.println("Opción no válida. Pulsa R para reiniciar o M para volver al menú.");
                        }
                    }
                    continue;
                }
                // turno de la IA
                int maxQuitar = Math.min(4, palitos - 1);
                int jugadaIA = 1 + random.nextInt(maxQuitar);
                System.out.println("La máquina quita " + jugadaIA + " palitos.");
                palitos -= jugadaIA;

                if (palitos == 1) {
                    System.out.println("¡Has ganado! La máquina ha perdido.");
                    System.out.println("Pulsa R para reiniciar o M para volver al menú.");
                    while (true) {
                        String fin = scanner.nextLine().trim().toUpperCase();
                        if (fin.equals("R")) {
                            partidaTerminada = true;
                            break;
                        } else if (fin.equals("M")) {
                            salir = true;
                            partidaTerminada = true;
                            break;
                        } else {
                            System.out.println("Opción no válida. Pulsa R para reiniciar o M para menú.");
                        }
                    }
                }
            }
        }
    }
}


