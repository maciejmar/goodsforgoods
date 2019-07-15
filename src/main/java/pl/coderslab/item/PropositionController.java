package pl.coderslab.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.user.User;
import pl.coderslab.user.UserService;
/*import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;*/
import pl.coderslab.validation.PropositionValidationGroup;

import javax.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("/propositions")
public class PropositionController {

    private ItemService itemService;

    /*private PublisherService publisherService;*/

    private UserService userService;

    @Autowired
    public PropositionController(ItemService itemService, /*PublisherService publisherService,*/ UserService userService) {
        this.itemService = itemService;
      /*  this.publisherService = publisherService;*/
        this.userService = userService;
    }

    @GetMapping("/add")
    public String addItem(Model model) {
        model.addAttribute("item", new Item());
        return "item";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute @Validated(PropositionValidationGroup.class) Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "item";
        }
        item.setProposition(true);
        itemService.saveItem(item);
        return "redirect:list";
    }

    /*

    @GetMapping("/list")
    public String propositionList(Model model) {
        List<Item> propositions = itemService.findPropositions();
        model.addAttribute("propositions", propositions);
        return "propositionList";
    }

    @GetMapping("/update/{id}")
    public String updateItem(@PathVariable Long id, Model model) {
        Item item = itemService.findItemWithUsers(id);
        model.addAttribute("item", item);
        return "item";
    }

    @PostMapping("/update/{id}")
    public String updateItem(@ModelAttribute @Validated(PropositionValidationGroup.class) Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "item";
        }
        ItemService.updateItem(item);
        return "redirect:../list";
    }


    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "redirect:../list";
    }

    */

/*    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherService.findAll();
    }
*/
   /*

    @ModelAttribute("users")
    public List<User> getUsers() {
        return authorService.findAll();
    }
*/
}