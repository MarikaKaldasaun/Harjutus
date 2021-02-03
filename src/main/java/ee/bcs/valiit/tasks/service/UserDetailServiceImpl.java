package ee.bcs.valiit.tasks.service;

import ee.bcs.valiit.bankrepository2.BankRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private BankRepository2 bankRepository2;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
      // String password = bankRepository2.findPasswordByUsername(username);
        return User.withUsername (username)
                .password(bankRepository2.findPasswordByUsername (username))
                        .roles("USER").build();
    }
}

