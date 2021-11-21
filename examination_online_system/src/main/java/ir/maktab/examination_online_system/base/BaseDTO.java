package ir.maktab.examination_online_system.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class BaseDTO<PK extends Serializable> implements Serializable {

    private PK id;

}
