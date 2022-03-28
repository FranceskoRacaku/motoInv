package moto.inventory.tables.users;



import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    public Optional<Users> getUser(Integer id) {
        return usersRepository.findById(id);

    }

    public void addUsers(Users users) {
        Optional<Users> usersByUserName = usersRepository
                .findUsersByUserName(users.getUserName());
        Optional<Users> usersByUserEmail = usersRepository
                .findUsersByUserEmail(users.getUserEmail());
        if (usersByUserName.isPresent()) {
            throw new IllegalStateException("Username Taken");
        } else if (usersByUserEmail.isPresent()) {
            throw new IllegalStateException("Email Taken");
        }
        usersRepository.save(users);


    }

    public void deleteUser(Integer userId) {
        boolean exists = usersRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException(
                    "User with id " + userId + " does not exists!!");
        }
        usersRepository.deleteById(userId);
    }


//    @Transactional
//    public void updateUser(Integer userId, String userName, String userEmail, Integer userAge) {
//        Users users = usersRepository.findById(userId)
//                .orElseThrow(() -> new IllegalStateException(
//                        "User with id " + userId + " does no exist!!")
//                );
//
//
//        if (userName != null &&
//                userName.length() > 0 &&
//                !Objects.equals(users.getUserName(), userName)) {
//            users.setUserName(userName);
//        }
//
//        if (userEmail != null &&
//                userEmail.length() > 0 &&
//                !Objects.equals(users.getUserEmail(), userEmail)) {
//            Optional<Users> usersOptional = usersRepository
//                    .findUsersByUserEmail(userEmail);
//            if (usersOptional.isPresent()) {
//                throw new IllegalStateException("Email Taken");
//            }
//            users.setUserEmail(userEmail);
//        }
//        users.setUserAge(userAge);
//    }

    @Transactional
    public Users updateUser(Users user, Integer userId) {

        Users existingUser = usersRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("USER Id" + userId));

//        if (userName != null &&
//                userName.length() > 0 &&
//                !Objects.equals(users.getUserName(), userName)) {
//            existingUser.setUserName(user.getUserName());
//        }
//
//        if (userEmail != null &&
//                userEmail.length() > 0 &&
//                !Objects.equals(user.getUserEmail(), userEmail)) {
//            Optional<Users> usersOptional = usersRepository
//                    .findUsersByUserEmail(userEmail);
//            if (usersOptional.isPresent()) {
//                throw new IllegalStateException("Email Taken");
//            }
//            existingUser.setUserEmail(user.getUserEmail());
//        }

        existingUser.setUserName(user.getUserName());
        existingUser.setUserEmail(user.getUserEmail());
        existingUser.setUserAge(user.getUserAge());

        usersRepository.save(existingUser);
        return existingUser;
    }
}