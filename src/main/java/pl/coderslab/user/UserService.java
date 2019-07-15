package pl.coderslab.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;
    /*private UserDao userDao;*/

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userRepository.save(user);
    }

    public User findByemailQuery(String email) {
        return userRepository.findUserByEmail(email);

    }
    public List<User> findAll(){
        return userRepository.findAll();

    }


}