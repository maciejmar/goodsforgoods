package pl.coderslab.item;

import org.hibernate.validator.constraints.Range;
import pl.coderslab.user.User;
/*import pl.coderslab.category.Category;
import pl.coderslab.publisher.Publisher;*/
import pl.coderslab.validation.ItemValidationGroup;
import pl.coderslab.validation.PropositionValidationGroup;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(groups = {ItemValidationGroup.class, PropositionValidationGroup.class})
    @Size(min = 2, groups = {ItemValidationGroup.class, PropositionValidationGroup.class})
    private String name;

   /* @Range(min = 1, max = 5, groups = ItemValidationGroup.class)
    private int rating;*/

    @NotBlank(groups = PropositionValidationGroup.class)
    @Size(max = 600, groups = {ItemValidationGroup.class, PropositionValidationGroup.class})
    private String description;


    private String photo;

//    @Min(value = 2, groups = ItemValidationGroup.class)
//    private String wanted_by;

    private boolean proposition;

   /* @NotNull(groups = ItemValidationGroup.class)
    @ManyToOne
    private Publisher publisher;*/

    public List<User> getUsers() {
        return users;
    }

    @ManyToMany
    @JoinTable(name = "items_users",
            joinColumns = @JoinColumn(name = "items_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }*/

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

//    public String getWanted_by() {
//        return wanted_by;
//    }

//    public void setWanted_by(String wanted_by) {
//        this.wanted_by = wanted_by;
//    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
//                ", wanted_by='" + wanted_by + '\'' +
                ", proposition=" + proposition +
                '}';
    }
}
