package pl.coderslab.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }




    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user";
        }
        userService.saveUser(user);
        return "redirect:../";
    }

    @GetMapping ("/list")

    public String  getList (Model model){
        List<User> users =userRepository.findAll();
        model.addAttribute("users",users);
        return "userList";
    }

    @GetMapping("/tranList")
    public String showTranslit() {
        return "tranList";
    }

/*
    @GetMapping("/tranList")
    public String tranList(Model model) {
        List<User> users =userRepository.findAll();
        model.addAttribute("user",users);
        return "/tranList";

    }*/

   /*     @GetMapping("/update/{id}")
        public String update(@PathVariable Long id, Model model) {
            User user = userService.findUser(id);
            model.addAttribute("user", user);
            return "user";
        }

        @PostMapping("/update/{id}")
        public String update(@ModelAttribute @Valid User user, BindingResult result) {
            if (result.hasErrors()) {
                return "user";
            }
            userService.updateUser(user);
            return "redirect:../list";
        }

        @GetMapping("/delete/{id}")
        public String delete(@PathVariable Long id) {
            userService.deleteUser(id);
            return "redirect:../list";
        }*/


}
