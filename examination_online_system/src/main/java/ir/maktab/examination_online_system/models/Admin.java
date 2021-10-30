package ir.maktab.examination_online_system.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Admin.TABLE_NAME)
public class Admin extends User{

    public static final String TABLE_NAME = "admin_table" ;

}
