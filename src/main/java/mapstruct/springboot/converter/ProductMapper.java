package mapstruct.springboot.converter;

import mapstruct.springboot.dto.ProductDTO;
import mapstruct.springboot.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO to (Product product);

    Product from (ProductDTO productDTO);


}
