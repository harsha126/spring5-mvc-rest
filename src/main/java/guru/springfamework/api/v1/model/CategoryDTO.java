package guru.springfamework.api.v1.model;

import lombok.*;

/**
 * Created by jt on 9/24/17.
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
}
