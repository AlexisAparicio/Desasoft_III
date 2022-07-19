package ED;
import java.util.Random;
import java.util.Scanner;

public class EDproy {
String Player1, COM;
String matriz[][] = new String[3][3];
String opc;
int player,commx,commy,comx,comy,com;
Random rnd = new Random();
int upperbound = 10;
int x = 3;
int y = 3;
boolean subsalir2;
int a=00,b=01,c=02,d=10,e=11,f=12,g=20,h=21,i=22,turnoA=0,turnoB=0;
Scanner sn = new Scanner(System.in);
Scanner ss = new Scanner(System.in);


    public static void main(String[]args)
    {
        new EDproy();
    }

    EDproy()
    {
         System.out.println("Bienvenido al juego TIC TAC");
         System.out.println("Porfavor Escoger una opcion");
       boolean salir = false;
       int opcion; //Guardaremos la opcion del usuario
       boolean subsalir=false;

       while(!salir)
       {
        System.out.println("1. Iniciar el juego y escoger el valor a usar X - O");
        System.out.println("2. Iniciar el Juego");
        System.out.println("3. Salir");
         
        System.out.println("Escribe una de las opciones");
        opcion = sn.nextInt();

        switch(opcion){
            case 1:
                System.out.println("Has seleccionado la opcion 1");
                System.out.println("Favor Ingresar  el valor a usar entre X y O ");
               while(!subsalir){
                Player1 = ss.nextLine();
                Player1.charAt(0);
                if(Player1.toUpperCase().equals("X"))
                {   Player1="X";
                    COM="O";
                    subsalir=true;
                }
                else if(Player1.toUpperCase().equals("O"))
                { Player1="O";
                    COM = "X";
                    subsalir=true;
                }
                else   
                {
                    System.out.println("Favor ingresar un valor de los mencionados");
                    subsalir=false;
                }
               }
                break;
            case 2:
                System.out.println("Has seleccionado la opcion 2");
                System.out.println("El juego iniciara");
                System.out.println("El valor escogido es "+ Player1 + " el Valor de la computadora es "+COM );
                tablero();
                Game();
                tablero();
                break;
             case 3:
                System.out.println("Salir");
                salir=true;
                break;
             default:
                System.out.println("Solo números entre 1 y 3");

       }

    }
    }

    public void tablero()
    {   
        matriz[0][0] = " ___|";
        matriz[0][1] = " ___|";
        matriz[0][2] = " ___|";
        matriz[1][0] = " ___|";
        matriz[1][1] = " ___|";
        matriz[1][2] = " ___|";
        matriz[2][0] = " ___|";
        matriz[2][1] = " ___|";
        matriz[2][2] = " ___|";
        for (int x=0; x < matriz.length; x++)
        {
           for (int y=0; y < matriz[x].length; y++) 
           {
             System.out.print (matriz[x][y]);
             if (y!=matriz[x].length-1) System.out.print("\t");
           }
           System.out.println("|");
         }
    }
    public void Game()
    {
        for (int x=0; x < matriz.length; x++)
         {
            for (int y=0; y < matriz[x].length; y++) 
            {
              System.out.print (matriz[x][y]);
              if (y!=matriz[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
          }
            int turno= rnd.nextInt(upperbound);
            if(turno>6) turnoA=1;
                { if(turnoA>turnoB)
                    {turnoA++;
                    System.out.println("Usted empieza");
                    System.out.println("Posiciones disponibles "+"\n"+ a+ "  "+ b+" "+c+"\n"+ d+ "  "+ e+" "+f+"\n"+ g+ "  "+ h+" "+i);
                    while(!subsalir2)
                    {
                        System.out.println("Favor escoger la coordenada para colocar su valor");
                        System.out.println("Recordar el tablero del juego");
                        player=sn.nextInt();
                        if(player==a&&matriz[0][0].equals("__"))
                        {  
                            matriz[0][0]="X";
                            int commx= rnd.nextInt(x);
                            int commy= rnd.nextInt(y);
                            matriz[commx][commy]="O";
                            subsalir2=false;
                            System.out.println("entrando al if 00 "+ x);
                        }
                        if(player==b&&matriz[0][1].equals("___|"))
                        {
                            matriz[0][1]="X";
                            int commx= rnd.nextInt(x);
                            int commy= rnd.nextInt(y);
                            matriz[commx][commy]="O";
                            subsalir2=false;
                        }
                        if(player==c&&matriz[0][2].equals("___|"))
                        {
                            matriz[0][2]="X";
                            int commx= rnd.nextInt(x);
                            int commy= rnd.nextInt(y);
                            matriz[commx][commy]="O";
                            subsalir2=false;
                        }
                        if(player==d&&matriz[1][0].equals("___|"))
                        {
                            matriz[1][0]="X";
                            int commx= rnd.nextInt(x);
                            int commy= rnd.nextInt(y);
                            matriz[commx][commy]="O";
                            subsalir2=false;
                        }
                        if(player==e&&matriz[1][1].equals("___|"))
                        {
                            matriz[1][1]="X";
                            int commx= rnd.nextInt(x);
                            int commy= rnd.nextInt(y);
                            matriz[commx][commy]="O";
                            subsalir2=false;
                        }
                        if(player==f&&matriz[1][2].equals("___|"))
                        {
                            matriz[1][2]="X";
                            int commx= rnd.nextInt(x);
                            int commy= rnd.nextInt(y);
                            matriz[commx][commy]="O";
                            subsalir2=false;
                        }
                        if(player==g&&matriz[2][0].equals("___|"))
                        {
                            matriz[2][0]="X";
                            int commx= rnd.nextInt(x);
                            int commy= rnd.nextInt(y);
                            matriz[commx][commy]="O";
                            subsalir2=false;
                        }
                        if(player==h&&matriz[2][1].equals("___|"))
                        {
                            matriz[2][1]="X";
                            int commx= rnd.nextInt(x);
                            int commy= rnd.nextInt(y);
                            matriz[commx][commy]="O";
                            subsalir2=false;
                        }
                        if(player==i&&matriz[2][2].equals("___|"))
                        {
                            matriz[2][2]="X";
                            int commx= rnd.nextInt(x);
                            int commy= rnd.nextInt(y);
                            matriz[commx][commy]="O";
                            subsalir2=false;
                        }
                        else{
                        System.out.print("Favor ingresar un valor permitido");
                        subsalir2=false;
                        }

                        subsalir2=true;
                    }
            
                  }
                }
                 if(turnoB>turnoA)
             {
               {   turnoB++;
                 System.out.println("La Computadora empieza");
                while(!subsalir2)
                   {   int comx= rnd.nextInt(x);
                 int comy= rnd.nextInt(y);
                    if(com==a&&matriz[0][0].equals("___|"))
            {  
                matriz[0][0]="X";
                int commx= rnd.nextInt(x);
                int commy= rnd.nextInt(y);
                matriz[commx][commy]="O";
                System.out.println(commx+" "+commy);
            }
            if(player==b&&matriz[0][1].equals("___|"))
            {
                matriz[0][1]="X";
                int commx= rnd.nextInt(x);
                int commy= rnd.nextInt(y);
                matriz[commx][commy]="O";
            }
            if(player==c&&matriz[0][2].equals("___|"))
            {
                matriz[0][2]="X";
                int commx= rnd.nextInt(x);
                int commy= rnd.nextInt(y);
                matriz[commx][commy]="O";
            }
            if(player==d&&matriz[1][0].equals("__"))
            {
                matriz[1][0]="X";
                int commx= rnd.nextInt(x);
                int commy= rnd.nextInt(y);
                matriz[commx][commy]="O";
            }
            if(player==e&&matriz[1][1].equals("___|"))
            {
                matriz[1][1]="X";
                int commx= rnd.nextInt(x);
                int commy= rnd.nextInt(y);
                matriz[commx][commy]="O";
            }
            if(player==f&&matriz[1][2].equals("___|"))
            {
                matriz[1][2]="X";
                int commx= rnd.nextInt(x);
                int commy= rnd.nextInt(y);
                matriz[commx][commy]="O";
            }
            if(player==g&&matriz[2][0].equals("___|"))
            {
                matriz[2][0]="X";
                int commx= rnd.nextInt(x);
                int commy= rnd.nextInt(y);
                matriz[commx][commy]="O";
            }
            if(player==h&&matriz[2][1].equals("___|"))
            {
                matriz[2][1]="X";
                int commx= rnd.nextInt(x);
                int commy= rnd.nextInt(y);
                matriz[commx][commy]="O";
            }
            if(player==i&&matriz[2][2].equals("___|"))
            {
                matriz[2][2]="X";
                int commx= rnd.nextInt(x);
                int commy= rnd.nextInt(y);
                matriz[commx][commy]="O";
            }
            subsalir2=true;
        }
    }
  }
    }

}
