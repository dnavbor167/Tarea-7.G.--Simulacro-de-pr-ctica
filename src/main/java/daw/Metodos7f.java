/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author daniel
 */
public class Metodos7f {

    //Obtén una estructura Map donde para cada nombre de estación 
    //meteorológica se pueda consultar la precipitación acumulada de la misma. 
    //Muestra por consola el resultado de la estructura map obtenida. Opcional, hacerlo con API Stream.
    public static Map<String, Double> mapEstacion(List<Precipitacion> lista) {
        return lista.stream()
                .collect(Collectors.toMap((p) -> p.estacionMeteorologica(), p -> p.precipitacion()));
    }

    //Usando API Stream, muestra por consola el número de 
    //estaciones meteorológicas que han sido leídas entre el 
    //10 de octubre de 2017 y el 20 de octubre de 2017, ambos días incluidos.
    public static int mostrarEstaciones(List<Precipitacion> lista) {
        LocalDate fechaIni = LocalDate.of(2017, Month.OCTOBER, 10);
        LocalDate fechaFin = LocalDate.of(2017, Month.OCTOBER, 20);
        return (int)lista.stream()
                .filter((p)->p.fecha().isAfter(fechaIni) && p.fecha().isBefore(fechaFin))
                .count();
    }
    
    //Usando API Stream, calcula la media de precipitaciones de aquellas 
    //estaciones meteorológicas leídas entre el 10 de octubre de 2017 y 
    //el 20 de octubre de 2017, ambos días incluidos.
    public static double mediaFechas(List<Precipitacion> lista) {
        LocalDate fechaIni = LocalDate.of(2017, Month.OCTOBER, 10);
        LocalDate fechaFin = LocalDate.of(2017, Month.OCTOBER, 20);
        return lista.stream()
                .filter((p)->p.fecha().isAfter(fechaIni) && p.fecha().isBefore(fechaFin))
                .mapToDouble((p)->p.precipitacion())
                .average()
                .getAsDouble();
    }
}
