package mapstruct.springboot.converter;

import mapstruct.springboot.dto.ProductDTO;
import mapstruct.springboot.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "description", target = "desc"/*,defaultValue = "This is a default value of the description"*/)
    ProductDTO to (Product product);

/*
    @Mapping(source = "desc", target = "description")
*/
     @InheritInverseConfiguration
     Product from (ProductDTO productDTO);
 /**
  * if you have two attributes with different names
  * you have to use @Mapping to avoid the null value !
  * **/


 List<ProductDTO> ListTo (List<Product> product);

 List<Product> ListFrom (List<ProductDTO> productDTO);


}
