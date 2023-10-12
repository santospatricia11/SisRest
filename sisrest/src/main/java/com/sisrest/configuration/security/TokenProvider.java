package com.sisrest.configuration.security;

import com.sisrest.configuration.AppProperties;
import com.sisrest.model.entities.ContaEstudante;
import com.sisrest.model.entities.ContaServidor;
import com.sisrest.model.enums.Role;
import com.sisrest.repositories.ContaEstudanteRepository;
import com.sisrest.repositories.ContaServidorRepository;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(TokenProvider.class);

    private final AppProperties appProperties;

    @Autowired
    private ContaEstudanteRepository contaEstudanteRepository;

    @Autowired
    private ContaServidorRepository contaServidorRepository;

    public TokenProvider(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public String createToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String roleText = "";

        Optional<ContaEstudante> contaEstudante = contaEstudanteRepository.findByEmail(userPrincipal.getEmail());
        Optional<ContaServidor> contaServidor = contaServidorRepository.findByEmail(userPrincipal.getEmail());
        if (contaEstudante.isPresent() == true) {
            Role roleEnum = contaEstudante.get().getRole();
            roleText = roleEnum.getText();
        } else if (contaServidor.isPresent() == true) {
            Role roleEnum = contaServidor.get().getRole();
            roleText = roleEnum.getText();
        }
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + appProperties.getAuth().getTokenExpirationMsec());
        System.out.println("chegou aqui" + roleText);
        return Jwts.builder().setSubject(Long.toString(userPrincipal.getId())).claim("role", roleText).setIssuedAt(new Date()).setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, appProperties.getAuth().getTokenSecret()).compact();
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(appProperties.getAuth().getTokenSecret()).parseClaimsJws(token).getBody();

        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(appProperties.getAuth().getTokenSecret()).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }

}
