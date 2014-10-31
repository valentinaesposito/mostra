package com.github.valentinaesposito.mostra;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;

import com.github.valentinaesposito.mostra.model.Curatore;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

/**
 * Created by Peppe on 30/10/2014.
 */
public class TokenResource extends Controller {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            Curatore cur = new Curatore(request);

            if(!cur.getPassword().equals("ciccio"))
                throw new Exception("Login fallito");

            JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);

            JWTClaimsSet claimsSet = new JWTClaimsSet();
            claimsSet.setSubject(cur.getUsername());
            claimsSet.setIssueTime(new Date());

            SignedJWT signedJWT = new SignedJWT(header, claimsSet);

            JWSSigner signer = new MACSigner("passwordSegretaDelServer");
            signedJWT.sign(signer);

            PrintWriter writer = response.getWriter();
            writer.println(signedJWT.serialize());

            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
