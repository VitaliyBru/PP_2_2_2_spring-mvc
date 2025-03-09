package web.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Size(min = 3, max = 45, message = "Имя должно сотержать от 3 до 45 символов")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Поле должно быть заполнено")
    @Email(message = "Введите корректный e-mail адресс")
    @Column(name = "email")
    private String email;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
