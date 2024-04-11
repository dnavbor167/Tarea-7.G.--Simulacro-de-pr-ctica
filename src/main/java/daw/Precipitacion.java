/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package daw;

import java.time.LocalDate;

/**
 *
 * @author daniel
 */
public record Precipitacion(LocalDate fecha, String estacionMeteorologica, 
        String provincia, double precipitacion) {

    //PODRIAMOS USAR @JsonProperty("Nombre que está en el fichero")
    //ESTO SIRVE PARA LEER JSON Y EN LA VARIABLE LE HEMOS PUESTO 
    //OTRO NOMBRE O EN OTRO ORDEN
}
