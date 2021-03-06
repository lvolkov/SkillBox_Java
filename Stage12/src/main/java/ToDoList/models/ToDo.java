package ToDoList.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Класс ToDo.
 * Реализация сущности дела.
 *
 * @author Oleg Bech.
 * @email oleg071984@gmail.com
 */
@Entity
@Data
@Table(name = "TODO")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
    /**
     * Поле id;
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TODO_ID")
    private Long id;
    /**
     * Наименование дела.
     */
    private String name;
    /**
     * Дата начала.
     */
    @JsonFormat(pattern = "dd.MM.yyyy", shape = JsonFormat.Shape.STRING)
    private Date dateStart;
    /**
     * Дата завершения.
     */
    @JsonFormat(pattern = "dd.MM.yyyy", shape = JsonFormat.Shape.STRING)
    private Date dateEnd;
    /**
     * Описание.
     */
    private String description;
}
