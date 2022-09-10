package com.devinhouse.pcpbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassAllocationItemDto {

    private String className;
    private Long idClass;
    private List<Integer> months;
    private List<Long> weeks = new ArrayList<>();
    private List<LocalDate> weekInitialDates;
    private List<String> weeksTeachersNames = new ArrayList<>();
    private List<String> monthsDropdown = new ArrayList<>();

}
