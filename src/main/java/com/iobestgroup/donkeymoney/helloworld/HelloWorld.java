package com.iobestgroup.donkeymoney.helloworld;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Na podstawie poniższych adnotacji Hibernate tworzy nowa tabelę.
 *
 * '@Getter' i '@Setter' to adnotacje z projektu Lombok - gettery i settery są automatycznie generowane.
 * Jeśli nie będzie wam chciało tego skompilować, spróbujcie w ustawieniach zmienic opcje kompilatora (w IntellijIdea
 * należy zaznaczyc "enable annotation processing")
 *
 * @author miwas
 * @version 1.0
 * @since 21.10.17
 */
@Entity
@Table(name = "hello_world")
public class HelloWorld {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Getter
    @Setter
    @Column(name = "message", unique = false)
    private String message;
}
