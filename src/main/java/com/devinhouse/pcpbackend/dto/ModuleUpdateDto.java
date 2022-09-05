package com.devinhouse.pcpbackend.dto;

import com.devinhouse.pcpbackend.model.WeekEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModuleUpdateDto {

    @NotBlank(message = "Nome não pode estar em branco")
    @Size(max = 60)
    private String name;

    private List<WeekEntity> weekEntityList;
}
