package ru.itmo.highendsystem.secuity.util;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import ru.itmo.highendsystem.model.entity.Account;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class JwtTokenUtil {
    /**
     * 1 час
     */
    private static final int EXPIRE_DURATION = 60*60*1000;

    @Value("$(jwt:secret)")
    private static String jwtSecret = "itmo";

    public static String generateAccessToken(String login) {
        Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception expEx) {
            return false;
        }
    }

    public static String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
