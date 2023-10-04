package ru.itmo.highendsystem.secuity.util;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.itmo.highendsystem.model.entity.Account;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtTokenUtil {
    /**
     * 1 час
     */
    private final int EXPIRE_DURATION = 60*60*1000;

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generateAccessToken(String login) {
        Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception expEx) {
            return false;
        }
    }

    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
