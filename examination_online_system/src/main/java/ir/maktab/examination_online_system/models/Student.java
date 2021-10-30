package ir.maktab.examination_online_system.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Student.TABLE_NAME)
public class Student extends User{
    public static final String TABLE_NAME = "student_table";


    //


}
