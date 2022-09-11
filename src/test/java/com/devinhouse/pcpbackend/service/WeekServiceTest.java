package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.dto.DashboardDto;
import com.devinhouse.pcpbackend.model.WeekEntity;
import com.devinhouse.pcpbackend.repository.WeekRepository;
import com.devinhouse.pcpbackend.util.DashboardUtilTest;
import com.devinhouse.pcpbackend.util.WeekUtilTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class WeekServiceTest {

    @Mock
    private DashboardDto dashboardDtoMock;

   @Mock
   private WeekRepository weekRepositoryMock;

   @InjectMocks
   private WeekService weekService;

   private final WeekEntity expectedWeek = WeekUtilTest.expectedWeek();

   private final DashboardDto expectedDashboard = DashboardUtilTest.expectedDashboard();


    @Test
   @DisplayName("Deve retornar uma semana quando informado um id válido.")
   public void  shouldToSearchAWeekWithId() {
       // #1 to prepare
       Mockito.when(weekRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(expectedWeek));
       // #2 test method called
       var realWeek = weekService.findById(1L);
       // #3 to compare
       Assertions.assertEquals(expectedWeek, realWeek);
       Mockito.verify(weekRepositoryMock, Mockito.times(1)).findById(1L);
   }

   @Test
   @DisplayName("Deve retornar uma lista de semanas.")
   public void shouldToReturnAWeekList() {
       // #1 to prepare
       var expectedWeekList = List.of(expectedWeek, expectedWeek);
       Mockito.when(weekRepositoryMock.findAll()).thenReturn((expectedWeekList));
       // #2 test method called
       var realWeekList = weekService.findAll();
       // #3 to compare
       Assertions.assertNotNull(realWeekList);
       Assertions.assertEquals(expectedWeekList, realWeekList);
   }

   @Test
   @DisplayName("Deve retornar uma semana cadastrada com sucesso.")
   public void shouldToReturnAWeekWhenItWasSuccessSaved() {
       // #1 to prepare
       var expectedWeekSaved = WeekUtilTest.expectedSaveWeek();
       Mockito.when(weekRepositoryMock.save(Mockito.any(WeekEntity.class))).thenReturn(expectedWeekSaved);
       // #2 test method called
       var realWeekSaved = weekService.insert(expectedWeekSaved);
       // #3 to compare
       Assertions.assertEquals(expectedWeekSaved, realWeekSaved);
   }

   @Test
   @DisplayName("Deve remover uma semana pelo id com sucesso.")
   public void shouldToRemoveAWeekWithId() {
       // #1 to prepare
       Mockito.doNothing().when(weekRepositoryMock).deleteById(Mockito.anyLong());
       // #2 test method called
       weekService.delete(1L);
       // #3 to compare
       Mockito.verify(weekRepositoryMock, Mockito.times(1)).deleteById(1L);
   }

    @Test
    @DisplayName("Deve retornar uma lista de informações dashboard.")
    public void shouldToReturnADashboardList() {
        // #1 to prepare
        var expectedDashboardList = List.of(expectedDashboard, expectedDashboard);
        Mockito.when(dashboardDtoMock.toString()).thenReturn((expectedDashboardList).toString());
        // #2 test method called
        var realDashboardList = weekService.findAll();
        // #3 to compare
        Assertions.assertNotNull(realDashboardList);
        // Assertions.assertEquals(expectedDashboardList, realDashboardList);
    }
}
