package com.devinhouse.pcpbackend.dto;

import com.devinhouse.pcpbackend.model.WeekEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class ModuleCreateDto {

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    @OneToMany
    private List<WeekEntity> weekEntityList;
}
