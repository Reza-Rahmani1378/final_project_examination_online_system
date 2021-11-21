package ir.maktab.examination_online_system.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = Admin.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
public class Admin extends User {

    public static final String TABLE_NAME = "admin_table";


    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

}
