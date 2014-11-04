package com.github.valentinaesposito.mostra;

import com.github.valentinaesposito.mostra.exception.FieldValidationException;
import com.github.valentinaesposito.mostra.model.Profilo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Peppe on 29/10/2014.
 */
public class Profiloresource  extends Controller{

    @Override
    // Tale metodo serve per fare richieste al DB
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Profilo profilo = Profilo.validate(Profilo.class, request.getParameter("idP"));
            if(profilo == null)
                throw new FieldValidationException();

            PrintWriter writer = response.getWriter();
            writer.println(profilo.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    // Tale metodo serve per fare inserimenti nel DB
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            String json = this.readBody(request.getReader());
            Profilo profilo = Profilo.fromJson(Profilo.class, json);
            System.out.println(profilo.toJson());
            profilo.save();

            PrintWriter writer = response.getWriter();
            writer.println(profilo.toJson());
        } catch(FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    // Tale metodo serve per fare un upload sul DB
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            String json = this.readBody(request.getReader());
            Profilo profilo = Profilo.fromJson(Profilo.class, json);
            profilo.update();

            PrintWriter writer = response.getWriter();
            writer.println(profilo.toJson());
        } catch(FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    // Tale metodo serve per eliminare un elemento nel DB
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Profilo profilo = Profilo.validate(Profilo.class, request.getParameter("idP"));
            profilo.delete();
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
