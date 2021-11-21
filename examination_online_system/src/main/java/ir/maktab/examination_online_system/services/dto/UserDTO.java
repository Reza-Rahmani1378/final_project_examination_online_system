package ir.maktab.examination_online_system.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import ir.maktab.examination_online_system.base.BaseDTO;
import ir.maktab.examination_online_system.models.enumeration.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO<Long> {

    private Long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @NotNull
    @JsonProperty("username")
    private String username;

    @JsonProperty("nationalCode")
    private String nationalCode;


    @NotNull
    @JsonProperty("password")
    private String password;

    @NotNull
    @JsonProperty("email")
    private String email;

    @NotNull
    @JsonProperty("userType")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    private boolean isConfirmed;
}
