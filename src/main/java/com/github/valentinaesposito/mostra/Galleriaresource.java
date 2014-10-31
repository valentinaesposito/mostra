package com.github.valentinaesposito.mostra;

import com.github.valentinaesposito.mostra.exception.FieldValidationException;
import com.github.valentinaesposito.mostra.model.Galleria;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Peppe on 29/10/2014.
 */
public class Galleriaresource extends Controller {

    @Override
    // Tale metodo serve per fare richieste al DB
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Galleria galleria = Galleria.validate(Galleria.class, request.getParameter("id"));
            if(galleria == null)
                throw new FieldValidationException();

            PrintWriter writer = response.getWriter();
            writer.println(galleria.toJson());
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
            Galleria galleria = Galleria.fromJson(Galleria.class, json);
            System.out.println(galleria.toJson());
            galleria.save();

            PrintWriter writer = response.getWriter();
            writer.println(galleria.toJson());
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
            Galleria galleria = Galleria.fromJson(Galleria.class, json);
            galleria.update();

            PrintWriter writer = response.getWriter();
            writer.println(galleria.toJson());
        } catch(FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    // Tale metodo serve per eliminare un elemento nel DB
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Galleria galleria = Galleria.validate(Galleria.class, request.getParameter("id"));
            galleria.delete();
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
