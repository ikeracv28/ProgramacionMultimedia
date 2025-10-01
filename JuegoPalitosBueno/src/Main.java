import java.awt.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Juego juego = new Juego();
        Menus menus = new Menus();
        int eleccion ;
        int modo;
        int eleccionSubmenu;

        while(true){
            menus.menu();
            System.out.println("Elige una opción: ");
            try {
                eleccion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                eleccion = 0;
            }

            switch (eleccion) {
                case 1:
                    menus.menuJugar();
                    eleccionSubmenu = Integer.parseInt(sc.nextLine());
                    switch (eleccionSubmenu){
                        case 1:
                            juego.jugadorVsJugador();
                            break;
                            case 2:
                                juego.jugadorVsIA();
                                break;
                                case 3:
                                    return;
                    }
                    break;
                    case 2:
                        juego.controlesReglas();
                        break;
                        case 3:
                            System.exit(0);
                            break;
            }
        }

    }
}