package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.model.User;
import com.orsolyazolcsak.allamvizsga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 512;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
    private static final SecureRandom RAND = new SecureRandom();

    public static void main(String[] args) {
        String salt = generateSalt(512).get();
        String password = "PaSSworD";
        String key = hashPassword(password, salt).get();
        boolean  legyentrue = verifyPassword("PaSSworD", key, salt);
        boolean legyenfalse = verifyPassword("PaSSword", key, salt);
        System.out.println("true here: " + legyentrue + ", false here: " + legyenfalse);
    }

    @Override
    public Set<User> findAll() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public void createNewUser(User newUser) {
        repository.save(newUser);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional <User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }


    public boolean checkUser(String username, char[] password) {
        return this.repository.findByUsername(username)
                .map(u -> verifyPassword(new String(password), u.getPassword(), u.getSalt()))
                .orElse(false);
    }

    public static Optional<String> generateSalt(final int length)   {

        if(length < 1){
            System.err.println("error in generateSalt: length must be > 0");
            return Optional.empty();
        }

        byte[] salt = new byte[length];
        RAND.nextBytes(salt);

        return Optional.of(Base64.getEncoder().encodeToString(salt));
    }

    public static Optional<String> hashPassword(String password, String salt){

        char[] chars = password.toCharArray();
        byte[] bytes = salt.getBytes();

        PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);

        Arrays.fill(chars, Character.MIN_VALUE);

        try{
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] securePassword = factory.generateSecret(spec).getEncoded();
            return Optional.of(Base64.getEncoder().encodeToString(securePassword));
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException ex){
            System.err.println("Exception encountered in hashPassword()");
            return Optional.empty();
        }
        finally{
            spec.clearPassword();
        }
    }

    public static boolean verifyPassword (String password, String key, String salt) {
        Optional<String> optEncrypted = hashPassword(password, salt);
        if (!optEncrypted.isPresent()) {
            return false;
        }
        return optEncrypted.get().equals(key);
    }
}
