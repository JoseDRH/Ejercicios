package com.example.EjercicoPractica.Controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ControllerObject {

    private List<String> path;
    private Map<String,String> querys;
    private Map<String,String> headers;
    private String urlOrigen;

    @Override
    public String toString() {
        return "ControllerObject{" +"\n" +
                " paths="+path+"\n ,"+
                " querys=" + querys +"\n ," +
                " headers=" + headers +"\n ," +
                " urlOrigen='" + urlOrigen + "\n ," +
                '}';
    }
}
