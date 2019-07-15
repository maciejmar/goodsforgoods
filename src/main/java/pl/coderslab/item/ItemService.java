package pl.coderslab.item;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.user.User;

import java.awt.print.Book;
import java.util.List;

@Service
@Transactional
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public void updateItem(Item item) {
        itemRepository.save(item);
    }


    public void deleteItem(Long id){itemRepository.deleteById(id);}

    public Item findItem(Long id) {
        return  itemRepository.findById(id).orElse(null);
    }

    public List<Item> findItems() {
        return itemRepository.findAllByProposition(false);
    }

    public List<Item>findAllItemsWantedByUser(Long id) {
        return itemRepository.findAllItemsWantedByUser(id);
    }

    public List<Item> findAllItems (){ return itemRepository.findAll();}

   /* public List<User> findAllItemsbyUser(){return itemRepository.findUsers();}*/

    public Item findItemWithUsers(Long id) {
        Item item = findItem(id);
        Hibernate.initialize(item.getUsers());
        return item;
    }




//  public User findUser(Long id) {
//       return itemRepository.findById(id).orElse(null);
//   }







}