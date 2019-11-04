package com.bh.workouts.bhworkoutapp.services.user;

import com.bh.workouts.bhworkoutapp.models.RoleEnum;
import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findUserByEmail(String email) {

        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(email)) return user;
        }

        return new User();
    }

    @Override
    public User findUserByLogin(String login) {

        for (User user : userRepository.findAll()) {
            if (user.getLogin().equals(login)) return user;
        }

        return new User();
    }

    @Override
    public User findUserByLastName(String lastName) {

        for (User user : userRepository.findAll()) {
            if (user.getLastName().equals(lastName)) return user;
        }

        return new User();
    }

    public void saveUser(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.setActive(1);

//        Role userRole = roleRepository.findByRole("USER");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

        user.setRoles(RoleEnum.USER);

        userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
