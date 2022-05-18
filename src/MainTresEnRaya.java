import java.util.Scanner;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

/**
 * Clase principal que implementa la partida, para
 * ello se sirve de la clase TresEnRaya que implementa los
 * elementos del juego propiamente dicho: tablero, fichas, movimientos
 * También utiliza una librería auxiliar para poder enviar códigos
 * de color a la consola
 
 * @author loned
 * 
 */
public class MainTresEnRaya {

	/**
	 * Emulación de consola Ansi 
	 */
	public static Ansi scr0;
	
	/**
	 * menú del juego, pinta en pantalla las opciones disponibles y 
	 * solicita al jugador la elección de una ellas
	 * @return sel Opción elegida por el jugador
	 */
	public static int menu() {	
		int sel = 0;

		Scanner teclado = new Scanner(System.in);
		System.out.println(scr0.fgBrightCyan());
		System.out.println("---- Opciones ----");
		System.out.print(scr0.fg(Ansi.Color.WHITE));
		System.out.println("1. Mueve Jugador 1");
		System.out.println("2. Mueve Jugador 2");
		System.out.println("0. Termina Partida");
		System.out.println(scr0.fgBrightCyan());
		System.out.println("------------------");
		System.out.println(scr0.fgBrightYellow());
		System.out.print(">>>?");
		System.out.print(scr0.fg(Ansi.Color.WHITE));
		sel = teclado.nextInt();
		return sel;
                
	}
/**
 * Función principal, donde se gestiona la partida
  * <br>
 * Consultar el método: {@link TresEnRaya#mostrarTablero}
 * @param args	Parámetro sin uso, se manteniene por compatibidad
 * @see "Clase 3 en raya"
 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Seudocódigo
		 *  Instancia partida
		 *  Limpia y muestra tablero
		 *  mientras exista una opción valida
		 *  	opcion = menu (Presenta y elige opciones de juego)
		 *  	Ejecuta turnos de jugador 1/2
		 *  	y muestra la jugada
		 *  	o abandona la partida  
		 */
	                        
                AnsiConsole.systemInstall();			// Activar
		int opc = -1;
		scr0 = new Ansi();
		// creamos una partida
		TresEnRaya jugar = new TresEnRaya();
		jugar.limpiarTablero();
	        jugar.mostrarTablero();
		while (opc != 0) {
			opc = menu();		
		    if((opc == 1) || (opc ==2 )) {
		        jugar.movimientoJugador(opc);
		        jugar.mostrarTablero();
		      } else if(opc==0) {
		        opc = 0;
		        System.out.println(scr0.fg(Ansi.Color.GREEN));
		        System.out.println("Partida Terminada");
		      } else {
		    	  System.out.println(scr0.fg(Ansi.Color.RED));
		    	  System.out.println("Opcion no valida!");
				  opc = -1;
		      }	
		    System.out.println(scr0.fg(Ansi.Color.WHITE));
		} // while
		AnsiConsole.systemUninstall();// Terminar
	}	
}
