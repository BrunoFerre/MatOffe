package com.mattoffe.Eccomerce.configuration;


import com.mattoffe.Eccomerce.model.Person;
import com.mattoffe.Eccomerce.model.enums.PersonType;
import com.mattoffe.Eccomerce.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    private PersonRepository personRepository;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            Person person = personRepository.findByEmail(username);
            if (person != null) {
                if(person.getType().equals(PersonType.ADMIN)) {
                    return new User(person.getEmail(), person.getPassword(), AuthorityUtils.createAuthorityList("ADMIN"));
                }else{
                    return new User(person.getEmail(), person.getPassword(), AuthorityUtils.createAuthorityList("CLIENT"));
                }
            }else{
                throw new UsernameNotFoundException("User not found"+username);
            }
        });
    }
}
