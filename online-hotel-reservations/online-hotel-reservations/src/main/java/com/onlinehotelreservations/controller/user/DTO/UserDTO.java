package com.onlinehotelreservations.controller.user.DTO;

import com.onlinehotelreservations.entity.RoleEntity;
import com.onlinehotelreservations.shared.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private int id;

    @NotBlank(message = "Username can't be blank")
    @Pattern(regexp = "^\\S*$", message = "Username can't be white spaces")
    @Size(min = 8, message = "Username must be 8 characters")
    private String userName;

    private Set<RoleEntity> roleEntities;

    @NotBlank(message = "Fist name is required")
    @NotNull
    private String firstName;

    @NotBlank(message = "Last name is required")
    @NotNull
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthday;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "(0)+([0-9]{9})\\b", message = "Phone not in correct format")
    private String phone;
}