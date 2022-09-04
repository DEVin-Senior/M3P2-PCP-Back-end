package com.devinhouse.pcpbackend.dto;

import com.devinhouse.pcpbackend.model.WeekEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModuleReadDto {

    private Long id;
    private String name;
    private List<WeekEntity> weekEntityList;
}
