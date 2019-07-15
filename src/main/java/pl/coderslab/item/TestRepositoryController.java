package pl.coderslab.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;


import java.util.List;

@Controller
public class TestRepositoryController {

    private ItemRepository itemRepository;

    private UserRepository userRepository;

    public TestRepositoryController(ItemRepository itemRepository, UserRepository authorRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = authorRepository;
    }

    @Autowired


    @GetMapping("/findAll")
    @ResponseBody
    public String getItems() {
        List<Item> items = itemRepository.findAll();
        return items.toString();
    }

    @GetMapping("/findByTitle/{title}")
    @ResponseBody
    public String findByName(@PathVariable String name) {
        List<Item> items = itemRepository.findByName(name);
        return items.toString();
    }



    @GetMapping("/findByUsersId/{id}")
    @ResponseBody
    public String findByUsersId(@PathVariable Long id) {
        List<Item> items = itemRepository.findByUsersId(id);
        return items.toString();
    }



}