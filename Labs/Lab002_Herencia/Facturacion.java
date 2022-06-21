public class Facturacion
{
   public static void main(String[] args)
   {
      new Facturacion();
   }

   Facturacion()
   {
      Empleado empleado = new Empleado();
      empleado.setNombre("Juan");
      empleado.setApellido("Perez");
      empleado.setDepto("Informatica");
      System.out.println(empleado.getNombre());
      System.out.println(empleado.getApellido());
      System.out.println(empleado.getDepto());
   }
}
