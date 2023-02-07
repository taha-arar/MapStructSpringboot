package mapstruct.springboot.dto;

import lombok.*;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ProductDTO {

    @Id
    private Long id;
    private String name;
    private String desc;
    private int quantity;
    private long price;
}
