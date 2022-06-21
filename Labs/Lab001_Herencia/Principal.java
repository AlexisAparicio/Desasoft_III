public class Principal
{
   public static void main(String[] args)
   {
      new Principal();
   }

   Principal()
   {
      ClaseHija claseHija = new ClaseHija();
      claseHija.setAtributo1("Hola");
      claseHija.setAtributo2("Mundo");
      System.out.println(claseHija.getAtributo1());
      System.out.println(claseHija.getAtributo2());
   }
}