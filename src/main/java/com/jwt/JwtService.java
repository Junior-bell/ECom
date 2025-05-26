package com.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private static final String SECRET_KEY = "your-256-bit-secret-key-very-long-and-secure-your256bitsecretkeyvalue"; // Must be 256-bit (32+ chars for HS256)
    private static final long EXPIRATION_TIME = 86400000; // 24 hours

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY); // or use plain bytes if not base64
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // ✅ Generate JWT Token
    public String generateToken(String username, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ Validate token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSignInKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false; // Expired or tampered
        }
    }

    // ✅ Extract username
    public String getUsernameFromToken(String token) {
        return extractAllClaims(token).getSubject();
    }

    // ✅ Extract role
    public String getRoleFromToken(String token) {
        return (String) extractAllClaims(token).get("role");
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
