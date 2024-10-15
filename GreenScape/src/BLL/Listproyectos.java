package BLL;
import java.util.Date;
import java.util.LinkedList;

public class Listproyectos {
    private static LinkedList<Proyecto> proyectos;

    public static LinkedList<Proyecto> getInstance() {
        if (proyectos == null) {
            proyectos = new LinkedList<>();
            llenarProyectos(); 
        }
        return proyectos;
    }

    private static void llenarProyectos() {
        proyectos.add(new Proyecto("Proyecto 1", 1, new Date(), "Activo"));
        proyectos.add(new Proyecto("Proyecto 2", 2, new Date(), "Concluido"));
        proyectos.add(new Proyecto("Proyecto 3", 3, new Date(), "Activo"));
    }
}
