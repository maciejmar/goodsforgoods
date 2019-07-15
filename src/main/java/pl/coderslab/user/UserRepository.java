package pl.coderslab.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {



    User findUserByEmail(String email);

    @Query("select a from User a where a.marks like ?1%")
    List<User> findByMarksQuery(int marks);

    @Modifying
    @Query(value = "delete from items_users where user_id = ?1", nativeQuery = true)
    void deleteAuthorRalation(Long userId);


    List<User> findByLastname(String lastname);







}
