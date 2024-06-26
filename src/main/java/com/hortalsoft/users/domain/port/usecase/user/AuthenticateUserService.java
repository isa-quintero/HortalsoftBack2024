package com.hortalsoft.users.domain.port.usecase.user;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;

import com.hortalsoft.users.domain.entity.AssociationEntity;
import com.hortalsoft.users.domain.entity.CustomerEntity;
import com.hortalsoft.users.domain.entity.FarmerEntity;
import com.hortalsoft.users.domain.entity.UserEntity;
import com.hortalsoft.users.domain.port.input.user.AuthenticateUserUseCase;
import com.hortalsoft.users.domain.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class AuthenticateUserService implements AuthenticateUserUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final UserRepository userRepository;
    private final Key key;

    @Autowired
    public AuthenticateUserService(UserRepository userRepository, @Value("${jwt.secret}") String secretKey) {
        this.userRepository = userRepository;
        this.key = new SecretKeySpec(Base64.getDecoder().decode(secretKey), "HmacSHA256");
    }

    @Override
    public Map<String, String> execute(String idToken) {
        Map<String, String> response = new HashMap<>();
        try {
            var claims = Jwts.parser().setSigningKey(key).parseClaimsJws(idToken).getBody();
            String userEmail = claims.get("email", String.class);

            Optional<UserEntity> optionalUser = userRepository.findByEmail(userEmail);
            if (optionalUser.isPresent()) {
                UserEntity user = optionalUser.get();

                if (user instanceof FarmerEntity farmer) {
                    response.put("message", "Usuario autenticado como AGRICULTOR: " + farmer.getEmail());
                    response.put("asociacion", farmer.getAssociation() != null ? String.valueOf(farmer.getAssociation()) : "N/A");
                } else if (user instanceof AssociationEntity) {
                    response.put("message", "Usuario autenticado como ASOCIACION: " + user.getEmail());
                } else if (user instanceof CustomerEntity) {
                    response.put("message", "Usuario autenticado como CONSUMIDOR: " + user.getEmail());
                } else {
                    throw new ExceptionHortalsoft("Tipo de usuario no reconocido.", 5002, layer);
                }

                return response;
            } else {
                throw new ExceptionHortalsoft("Usuario no encontrado.", 5001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Autenticación fallida.", 500, layer, exception);
        }
    }
}


