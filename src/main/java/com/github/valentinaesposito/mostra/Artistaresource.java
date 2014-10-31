package com.github.valentinaesposito.mostra;

import com.github.valentinaesposito.mostra.exception.FieldValidationException;
import com.github.valentinaesposito.mostra.model.Artisti;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Peppe on 31/10/2014.
 */
public class Artistaresource extends Controller {

    @Override
    // Tale metodo serve per fare richieste al DB
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Artisti artista = Artisti.validate(Artisti.class, request.getParameter("id"));
            if(artista == null)
                throw new FieldValidationException();

            PrintWriter writer = response.getWriter();
            writer.println(artista.toJson());
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
            Artisti artista = Artisti.fromJson(Artisti.class, json);
            System.out.println(artista.toJson());
            artista.save();

            PrintWriter writer = response.getWriter();
            writer.println(artista.toJson());
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
            Artisti artista = Artisti.fromJson(Artisti.class, json);
            artista.update();

            PrintWriter writer = response.getWriter();
            writer.println(artista.toJson());
        } catch(FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    // Tale metodo serve per eliminare un elemento nel DB
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Artisti artista = Artisti.validate(Artisti.class, request.getParameter("id"));
            artista.delete();
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
