package com.opd_management.security.jwt;

import java.util.Date;
import java.security.Key;


import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil { 

	private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	// Token validity (10 hours)
	private static final long JWT_EXPIRATION_MS = 10 * 60 * 60 * 1000;
	
	public String generateToken(String subject) {
		
		return Jwts.builder()
				.setSubject(subject)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+ JWT_EXPIRATION_MS))
				.signWith(key)
				.compact();
				
	}
	// Extract username/email from token
	public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // Validate token
    public boolean isTokenValid(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    // Parse JWT claims
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}

