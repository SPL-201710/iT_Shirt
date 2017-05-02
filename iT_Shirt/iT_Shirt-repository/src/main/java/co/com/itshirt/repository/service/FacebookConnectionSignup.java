package co.com.itshirt.repository.service;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Service;

import co.com.itshirt.domain.Usuario;
import co.com.itshirt.enums.EnumEstadoUsuario;
import co.com.itshirt.enums.EnumRol;
import co.com.itshirt.enums.EnumSexo;
import co.com.itshirt.repository.RolRepository;
import co.com.itshirt.repository.UserRepository;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolRepository rolRepository;
    
    final static String[] fieldsToMap = { "id", "about", "age_range", "birthday",
            "context", "cover", "currency", "devices", "education",
            "email", "favorite_athletes", "favorite_teams",
            "first_name", "gender", "hometown", "inspirational_people",
            "installed", "install_type", "is_verified", "languages",
            "last_name", "link", "locale", "location", "meeting_for",
            "middle_name", "name", "name_format", "political",
            "quotes", "payment_pricepoints", "relationship_status",
            "religion", "security_settings", "significant_other",
            "sports", "test_group", "timezone", "third_party_id",
            "updated_time", "verified", "viewer_can_send_gift",
            "website", "work" };

    @Override
    public String execute(Connection<?> connection) {
        System.err.println("signup === .:::::::::"); //Registro de usuario via FCB
        final Facebook facebook = (Facebook) connection.getApi();
        final User userProfile = facebook.fetchObject("me", User.class, fieldsToMap);
        Usuario user = this.userRepository.findByIdRedSocial(userProfile.getId());
        if (user == null) { //Si no esta creado se procede a generarlo en BD:
        	user = new Usuario();
            user.setUsername(connection.getDisplayName());
            user.setNombres(userProfile.getFirstName());
            user.setApellidos(userProfile.getLastName());
            user.setEmail("Sin información");
            user.setTelefono("Sin información");
            user.setGenero(EnumSexo.getValorFacebook(userProfile.getGender()).getCodigo());
            user.setPassword(randomAlphabetic(8));
            user.setEstado(EnumEstadoUsuario.ACTIVO.getSigla());
            user.setIdRedSocial(userProfile.getId());
            user.setRol(this.rolRepository.findBySigla(EnumRol.COMPRADOR.getSigla()));
            this.userRepository.save(user);
        }
        
        return user.getUsername();
    }

}
