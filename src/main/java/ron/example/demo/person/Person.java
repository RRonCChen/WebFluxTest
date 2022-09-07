package ron.example.demo.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Table("person")
public class Person {
    @Id
    @Column("id")
    private Integer id;
    @Column("age")
    private Integer age;
    @Column("name")
    private String name;
}
