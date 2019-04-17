package colecciones;

import java.util.Comparator;

public class OrdenarAlumnoPorId 
        implements Comparator<Alumno>{

    @Override
    public int compare(Alumno o1, Alumno o2) {
    
        return o1.getId() - o2.getId();
        
    
    }
    
}
