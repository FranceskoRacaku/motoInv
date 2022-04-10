package moto.inventory.tables.users;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://motoang.herokuapp.com")
@RequestMapping(path = "users")

public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getUsers(){
        return usersService.getUsers();

    }

    @GetMapping(path = "{id}")
    public Optional<Users> getUser(@PathVariable Integer id){
        return usersService.getUser(id);
    }


    @PostMapping
    public void addUsers(@RequestBody Users users) {
        usersService.addUsers(users);
    }


    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        usersService.deleteUser(userId);
    }


    @PatchMapping("{userId}")
    public ResponseEntity<Users> updateUser(
            @PathVariable(value = "userId") Integer userId,
            @RequestBody Users user){
        return new ResponseEntity<Users>(usersService.updateUser(user, userId), HttpStatus.OK);

    }
//
//    @PatchMapping(path = "{userId}")
//    public void updateUser(
//            @PathVariable Integer userId,
//            @RequestParam(required = false) String userName,
//            @RequestParam(required = false) String userEmail,
//            @RequestParam(required = false) Integer userAge){
//        usersService.updateUser(userId, userName, userEmail, userAge);
//    }
}