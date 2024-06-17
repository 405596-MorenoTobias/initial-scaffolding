package ar.edu.utn.frc.tup.lciii.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //Indica que la clase tiene metodos que levantan beans

public class MaperConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean("Merge Mapper")
    public ModelMapper mergeMapper(){
        ModelMapper mapper = new ModelMapper();

        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        return mapper;
    }

    @Bean
    public ObjectMapper objectMapper(){
       ObjectMapper objectMapper = new ObjectMapper();
       objectMapper.registerModule(new JavaTimeModule());

       return objectMapper;
    }
}
