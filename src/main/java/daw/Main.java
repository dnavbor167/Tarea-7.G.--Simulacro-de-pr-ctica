/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author daniel
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //Procede a leer el fichero adjunto, carga los datos en una lista 
        //de objetos POJO y a muestra los registros contenidos la lista usando la consola.
        List<Precipitacion> lista = readWrite.readJson("precipitacionesBadajoz.json");
        lista.forEach(System.out::println);

        System.out.println("\nMostramos Map\n");

        //Obtén una estructura Map donde para cada nombre de estación 
        //meteorológica se pueda consultar la precipitación acumulada 
        //de la misma. Muestra por consola el resultado de la estructura 
        //map obtenida. 
        Map<String, Double> map = Metodos7f.mapEstacion(lista);

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        //Guarda en un fichero JSON, en la raíz del proyecto, el 
        //resultado del map. Pasa el objeto map directamente 
        //a la hora de generar el archivo.
        readWrite.writeJson("map.json", map);

        //Usando API Stream, muestra por consola el registro que tiene
        //la mayor precipitación.
        double mayorPrecipitacion = lista.stream()
                .mapToDouble((p) -> p.precipitacion())
                .max()
                .getAsDouble();
        System.out.println("\nLa mayor precipitación es: " + mayorPrecipitacion);

        //Usando API Stream, muestra por consola el número de 
        //estaciones meteorológicas que han sido leídas entre el 
        //10 de octubre de 2017 y el 20 de octubre de 2017, ambos días incluidos.
        System.out.println("Hay " + Metodos7f.mostrarEstaciones(lista) + " estaciones");

        //Usando API Stream, calcula la media de precipitaciones de aquellas 
        //estaciones meteorológicas leídas entre el 10 de octubre de 2017 y 
        //el 20 de octubre de 2017, ambos días incluidos.
        System.out.printf("La media de las precipitaciones es %.2f", Metodos7f.mediaFechas(lista));
    }
}
