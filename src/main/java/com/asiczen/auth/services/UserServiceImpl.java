package com.asiczen.auth.services;


import com.asiczen.auth.dtos.LoginRequestDto;
import com.asiczen.auth.dtos.LogoutRequestDto;
import com.asiczen.auth.dtos.SignUpRequestDto;
import com.asiczen.auth.entites.Token;
import com.asiczen.auth.entites.User;
import com.asiczen.auth.repo.TokenRepository;
import com.asiczen.auth.repo.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenRepository tokenRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder,
                           TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenRepository = tokenRepository;
    }


    private static Token getToken(User user) {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plus(30, ChronoUnit.DAYS);

        // Convert LocalDate to Date
        Date expiryDate = Date.from(thirtyDaysLater.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Token token = new Token();
        token.setUser(user);
        token.setExpiryAt(expiryDate);
        token.setValue(RandomStringUtils.randomAlphanumeric(128));
        return token;
    }


    @Override
    public Token login(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            // throw user not exists exception
            return null;
        }

        User user = userOptional.get();

        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            // throw password not matching exception
            return null;
        }

        Token token = getToken(user);

        // TODO 1: Change the above token to a JWT Token

        return tokenRepository.save(token);
    }

    @Override
    public User signUp(SignUpRequestDto requestDto) {
        User u = new User();
        u.setEmail(requestDto.getEmail());
        u.setUserName(requestDto.getUserName());
        u.setPassword(bCryptPasswordEncoder.encode(requestDto.getPassword()));
        u.setFirstName(requestDto.getFirstName());
        u.setLastName(requestDto.getLastName());
        return userRepository.save(u);
    }

    @Override
    public void logout(String token) {
        Optional<Token> token1 = tokenRepository.findByValueAndDeletedEquals(token, false);

        if (token1.isEmpty()) {
            // throw TokenNotExistsOrAlreadyExpiredException();
            return;
        }
        Token tkn = token1.get();
        tkn.setDeleted(true);
        tokenRepository.save(tkn);
    }

    public User validateToken(String token) {
        Optional<Token> tkn = tokenRepository.
                findByValueAndDeletedEqualsAndExpiryAtGreaterThan(token, false, new Date());

        return tkn.map(Token::getUser).orElse(null);

        // TODO 2: Instead of validating via the DB, as the token is now a JWT
        // token, validate using JWT

    }

}