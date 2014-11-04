package com.github.valentinaesposito.mostra;

import com.github.valentinaesposito.mostra.exception.FieldValidationException;
import com.github.valentinaesposito.mostra.model.Curatore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Peppe on 27/10/2014.
 */
public class Curatoreresource extends Controller {

    @Override
    // Tale metodo serve per fare inserimenti nel DB
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            String json = this.readBody(request.getReader());
            Curatore curatore = Curatore.fromJson(Curatore.class, json);
            System.out.println(curatore.toJson());
            curatore.save();

            PrintWriter writer = response.getWriter();
            writer.println(curatore.toJson());
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
            Curatore curatore = Curatore.fromJson(Curatore.class, json);
            curatore.update();

            PrintWriter writer = response.getWriter();
            writer.println(curatore.toJson());
        } catch(FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    // Tale metodo serve per eliminare un elemento nel DB
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Curatore curatore = Curatore.validate(Curatore.class, request.getParameter("id"));
            curatore.delete();
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
