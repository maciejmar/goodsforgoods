package pl.coderslab.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.user.User;

import java.awt.print.Book;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>,ItemRepoCustom {


    List<Item> findByName(String name);

    @Query("select b from Item b where b.name = ?1")
    List<Item> findByNameQuery(String name);



    List<Item> findByUsersId(Long id);

    @Modifying
    @Query(value = "delete from items_users where item_id = ?1", nativeQuery = true)
    void deleteItemRelations(Long id);


    List<Item> findAllByProposition(boolean proposition);

    @Query(value = "select * from gfg.items_users where users_id = ?1", nativeQuery = true)
    List<Item> findAllItemsWantedByUser(Long id);

   /* @Query(value="select * from gfg.items_users where users_id = ?1"), nativeQuery = true)
    List<Item> findAaItemsWantedByUser(Long id);*/
}
