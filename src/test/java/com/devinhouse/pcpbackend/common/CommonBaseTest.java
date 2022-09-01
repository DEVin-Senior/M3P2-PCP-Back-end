package com.devinhouse.pcpbackend.common;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
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

}
