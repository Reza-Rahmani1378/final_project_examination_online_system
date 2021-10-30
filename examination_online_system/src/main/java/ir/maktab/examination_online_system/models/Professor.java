package ir.maktab.examination_online_system.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Professor.TABLE_NAME)
public class Professor extends User{

    public static final String TABLE_NAME = "professor_table" ;


}
