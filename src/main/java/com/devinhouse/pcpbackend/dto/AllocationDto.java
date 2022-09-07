package com.devinhouse.pcpbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllocationDto {

    private Long idClass;
    private Long idWeek;
    private Long idTeacher;

}
