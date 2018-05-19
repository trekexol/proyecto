package proyecto.ingsw.command;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;
import java.io.Serializable;


@ToString
@Data   //COMANDO ENCARGADO DEL INICIO DE SESIÓN A LA RED SOCIAL

public class UserSearchCommand implements Serializable {
    @NotNull(message = "Por favor, introduzca su nombre.")
    @NotEmpty(message = "Por favor, introduzca su nombre.")
    @Size(max = ValidationRules.FIRST_LAST_NAME_MAX_SIZE, message = "El nombre no puede contener más de 40 caracteres.")
    @Pattern(regexp = ValidationRules.FIRST_LAST_NAME_REGEX, message = "El nombre posee caracteres no válidos.")
    private String firstName;




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
