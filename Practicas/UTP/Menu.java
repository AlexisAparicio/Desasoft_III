import java.util.Scanner;
public class Menu {

	public static void main(String[] args) {
		
		Scanner sn= new Scanner(System.in);
		Scanner sn1= new Scanner(System.in);
		String valor;
		
		boolean salir = false;
		int opcion;
		//char lista;
		
		while(!salir){
			
			System.out.println("1. Llenar la lista- ");
			System.out.println("2. Listar Lista - ");
			System.out.println("3. Buscar valor en la lista - ");
			System.out.println("4. Eliminar valor en la lista - ");
			System.out.println("5. Salir");
			System.out.println("Escribe una de las opciones");
			opcion =sn.nextInt();
			
		switch(opcion) {
		case 1:
			System.out.print("Has Seleccionado la opcion 1. Llenar la lista- ");
			System.out.println("Favor ingrese los valores de la lista");
			valor=sn1.next();
			int a=valor.length();
			int[] listaa = new int[a+1] ;
			for (int n = 0;n <a; n++) 
			{
				listaa[a]= valor.charAt(n); 
				System.out.println (listaa[a]); 
			}
			sn1.close();
			break;
		case 2:
			System.out.print("Has Seleccionado la opcion 2. Listar la Lista ");
			break;
		case 3:
			System.out.print("Has Seleccionado la opcion 3. Buscar valor en la lista ");
			break;
		case 4:
			System.out.print("Has Seleccionado la opcion 4. Eliminar valor en la lista ");
			break;
		case 5:
			System.out.print("Has Seleccionado la opcion 5. Gracias por usar el programa , hasta luego");
			salir=true;
			break;
			default:
				System.out.println("Solo numeros del 1 al 5");
		}
		sn.close();
		}

	}

}
