package org.example.printonline.services;

import org.example.printonline.model.AuthUser;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;

    public UserService(final JdbcTemplate jdbcTemplate, final PasswordEncoder passwordEncoder) {
        this.jdbcTemplate = jdbcTemplate;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        AuthUser authUser;
        try {
            authUser = jdbcTemplate.queryForObject("select * from users where email = ?",
                    new Object[]{email},
                    ((resultSet, i) -> new AuthUser(
                            resultSet.getInt("id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("email"),
                            resultSet.getString("password"))));
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("No such user");
        }
        return authUser;
    }

    public void register(final String firstname, final String lastname, final String email, final String password) {
        jdbcTemplate.update("insert into users (first_name, last_name, email,password) values (?,?,?,?)",
                firstname, lastname, email, passwordEncoder.encode(password));
    }

//    public void login (final String email, final String password){
//        jdbcTemplate.execute();
//    }
}
