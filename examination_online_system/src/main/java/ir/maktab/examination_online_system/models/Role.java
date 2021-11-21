package ir.maktab.examination_online_system.models;

import ir.maktab.examination_online_system.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = Role.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends BaseEntity<Long> {

    public static final String TABLE_NAME = "role_table";
    public static final String NAME = "name";

    @Column(name = NAME)
    private String name;


}
