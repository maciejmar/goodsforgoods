package pl.coderslab.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.user.User;
import pl.coderslab.user.UserService;

import pl.coderslab.validation.ItemValidationGroup;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

    private UserService userService;


    @Autowired
    public ItemController(ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.userService = userService;

    }

    @GetMapping("/add")
    public String addItem(Model model) {
        model.addAttribute("item", new Item());
        return "item";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute @Validated(ItemValidationGroup.class) Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "item";
        }
        itemService.saveItem(item);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String itemListAll(Model model, HttpSession session) {
        User user = (User) session.getAttribute("userSession");
        List<Item> items = itemService.findAllItems();
        model.addAttribute("items", items);
        return "itemList";
    }

    @GetMapping("/select/{id}")

    public String selectItem(@PathVariable Long id, Model model) {
        Item item = itemService.findItemWithUsers(id);
        model.addAttribute("item", item);
        return "select";
    }

    @PostMapping("/select/{id}")
    public String selectItem(@ModelAttribute @Validated(ItemValidationGroup.class) Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "item";
        }
        itemService.updateItem(item);
        return "redirect:../list";
    }


    @GetMapping("/update/{id}")
    public String updateItem(@PathVariable Long id, Model model) {
        Item item = itemService.findItemWithUsers(id);
        model.addAttribute("item", item);
        return "item";
    }


    @PostMapping("/update/{id}")
    public String updateItem(@ModelAttribute @Validated(ItemValidationGroup.class) Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "item";
        }
        itemService.updateItem(item);
        return "redirect:../list";

    }

    @GetMapping("/{id}")
    @ResponseBody
    public String findById(@PathVariable Long id) {
        Item item = itemService.findItemWithUsers(id);
        return item.toString();
    }

    @ModelAttribute("users")
    public List<User> getUsers() {
        return userService.findAll();
    }


    @GetMapping("/tran")
    public String userList(Model model) {
/*
        List<User> users = itemService.findAllItemsbyUser();
        model.addAttribute("users", users);*/
        return "tran";

    }


   @GetMapping("/userItems")
    public String itemListForUser(Model model, HttpSession session) {
       User user = (User) session.getAttribute("userSession");
       List<Item> items = itemService.findAllItemsWantedByUser(user.getId());
       model.addAttribute("items", items);
       return "itemList";
   }


/*
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "redirect:../list";
    }
*/


}










