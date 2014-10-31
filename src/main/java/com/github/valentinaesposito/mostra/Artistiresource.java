package com.github.valentinaesposito.mostra;

import com.github.valentinaesposito.mostra.exception.FieldValidationException;
import com.github.valentinaesposito.mostra.model.Artisti;
import com.github.valentinaesposito.mostra.model.ModelList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by Peppe on 29/10/2014.
 */
public class Artistiresource extends Controller {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ModelList artisti;
        Map parameters = request.getParameterMap();
        try {
            if (parameters.size() == 0)
                artisti = Artisti.all(Artisti.class);
            else {
                ArrayList<String> keys = new ArrayList<String>();
                ArrayList<Object> values = new ArrayList<Object>();
                Enumeration<String> keysEnum = request.getParameterNames();

                while (keysEnum.hasMoreElements()) {
                    String key = keysEnum.nextElement();
                    keys.add(key);
                    values.add(this.getValue(Artisti.class, key, request));
                }

                artisti = Artisti.where(Artisti.class, keys, values, null, null);
            }

            PrintWriter writer = response.getWriter();
            writer.println(artisti.toJson());
        } catch (FieldValidationException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
