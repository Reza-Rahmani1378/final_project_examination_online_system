package ir.maktab.examination_online_system.services.dto.extra;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import ir.maktab.examination_online_system.base.BaseDTO;
import ir.maktab.examination_online_system.models.enumeration.UserType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangeStatusUserDTO extends BaseDTO<Long> {
    @NotNull
    @JsonProperty("userType")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    private String isConfirmed;
}
