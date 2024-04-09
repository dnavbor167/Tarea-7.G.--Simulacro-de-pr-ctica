/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author daniel
 */
public class readWrite {
    public static ArrayList<Precipitacion> readJson(String file) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());
        
        ArrayList<Precipitacion> precipitaciones = 
                mapeador.readValue(new File(file), 
                        mapeador.getTypeFactory()
                                .constructCollectionType(ArrayList.class, Precipitacion.class));
        
        return precipitaciones;
    }
    
    public static void writeJson(String file, Map<String,Double> map) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);
        
        mapeador.writeValue(new File(file), map);
    }
}
