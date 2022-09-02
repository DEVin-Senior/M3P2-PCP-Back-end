package com.devinhouse.pcpbackend.common;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public abstract class CommonBaseTest {

    /**
     * Configurações para a execução dos testes.
     * <p>
     * Esse método é executado antes de cada cenário de teste.
     */
    @Before
    public abstract void setUp();

    /**
     * Valida se os métodos mockados não terão mais interações.
     * <p>
     * Esse método é executado após cada cenário de teste.
     */
    @After
    public abstract void noMoreInteractions();

    /**
     * Método genérico que pode ser utilizado ao fim de cada teste para deletar todos os dados do repositório.
     * <p>
     * @param repository repositório da entidade que terá os dados apagados.
     */
    public void tearDown(JpaRepository repository){
        repository.deleteAll();
    }

}
