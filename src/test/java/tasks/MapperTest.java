package tasks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testMapperList() throws JsonProcessingException {
        List<SomeDto> dtoList = Arrays.asList(new SomeDto(1L, "val2"), new SomeDto(2L, "val3"));

        String valueAsString = mapper.writeValueAsString(dtoList);

        CollectionType typeReference = TypeFactory.defaultInstance().constructCollectionType(List.class, SomeDto.class);
        List<SomeDto> o = mapper.readValue(valueAsString, typeReference);

        System.out.println("LOL");
    }


}
