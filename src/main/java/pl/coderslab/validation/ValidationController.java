package pl.coderslab.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.user.User;
import pl.coderslab.item.Item;
/*import pl.coderslab.publisher.Publisher;*/

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {

    private Validator validator;

    @Autowired
    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/item/validate")
    public String validateItem(Model model) {
        Item item = new Item();
        item.setName("asdasdasd");

        List<ErrorInfo> list = new ArrayList<>();
        Set<ConstraintViolation<Item>> errors = validator.validate(item);
        if (!errors.isEmpty()) {
            for (ConstraintViolation<Item> error : errors) {
                String path = error.getPropertyPath().toString();
                String message = error.getMessage();
                list.add(new ErrorInfo(path, message));
            }
        }
        model.addAttribute("errors", list);
        return "errors";
    }

    @GetMapping("/user/validate")
    public String validateUser(Model model) {
        User user = new User();
        user.setPassword("aaa");
        user.setEmail("a@test.pl");


        List<ErrorInfo> list = new ArrayList<>();
        Set<ConstraintViolation<User>> errors = validator.validate(user);
        if (!errors.isEmpty()) {
            for (ConstraintViolation<User> error : errors) {
                String path = error.getPropertyPath().toString();
                String message = error.getMessage();
                list.add(new ErrorInfo(path, message));
            }
        }
        model.addAttribute("errors", list);
        return "errors";
        

    }
}