package com.github.valentinaesposito.mostra;

import com.github.valentinaesposito.mostra.exception.FieldValidationException;
import com.github.valentinaesposito.mostra.model.Curatore;
import com.github.valentinaesposito.mostra.model.Galleria;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Peppe on 04/11/2014.
 */
public class Esposizione extends Controller {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Curatore curator= Curatore.validate(Curatore.class,request.getParameter("idC"));
            Galleria g= Galleria.validate(Galleria.class,request.getParameter("idG"));
            if(curator == null)
                throw new FieldValidationException();
            curator.getGalleria().add(g);
            curator.update();
            PrintWriter writer = response.getWriter();
            writer.println(curator.toJson());
            response.setStatus(HttpServletResponse.SC_OK);
        } catch(FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }


   /* @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Curatore curator= Curatore.validate(Curatore.class,request.getParameter("idC"));
            if(curator == null)
                throw new FieldValidationException();
            curator.getGalleria().add(Galleria g);
            curator.update();
        } catch(FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }*/

       /* @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Curatore curator= Curatore.validate(Curatore.class,request.getParameter("idC"));
            curator.delete();
        } catch(FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }*/
}
