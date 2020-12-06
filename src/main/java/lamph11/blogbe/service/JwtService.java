package lamph11.blogbe.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtService {
    
    private static final String SECRET = "";
    private static final long EXPIRE_TIME = 8 * 60 * 60 * 1000;

    public static String generateToken(Authentication auth) {
        String name = auth.getName();
        List<String> roles = auth.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

        Date now = new Date(System.currentTimeMillis());
        Date expire = new Date(now.getTime() + EXPIRE_TIME);

        String token = Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, SECRET)
            .setIssuedAt(now)
            .setExpiration(expire)
            .setSubject(name)
            .claim("roles", roles)
            .compact();
        return token;
    }


    public static Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser()
            .setSigningKey(SECRET)
            .parseClaimsJws(token)
            .getBody();
        
        String username = claims.getSubject();
        List<String> roles = (List<String>) claims.get("roles");
        List<GrantedAuthority> authorities = roles.stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
        
        return new UsernamePasswordAuthenticationToken(
            username,
            null,
            authorities);
    }
}
