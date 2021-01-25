package br.com.leonardo.clientes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
//Classe responsável pela segurança das APIS (Resources)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                //.antMatchers("/api/clientes/**").hasAnyRole("USER")
                .antMatchers("/api/clientes/**").authenticated()
                .antMatchers("/api/usuarios", "/api/servicos-prestados/**").permitAll()
                .anyRequest().denyAll();
    }
}
