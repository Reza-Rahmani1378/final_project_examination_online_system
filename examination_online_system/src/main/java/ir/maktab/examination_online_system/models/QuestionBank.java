package ir.maktab.examination_online_system.models;


import ir.maktab.examination_online_system.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = QuestionBank.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionBank extends BaseEntity<Long> {

    public static final String TABLE_NAME = "question_bank_table";
    private static final String QUESTION_TYPE = "question_type";

    // course has one professor
    @OneToOne
    private Course course;


}
