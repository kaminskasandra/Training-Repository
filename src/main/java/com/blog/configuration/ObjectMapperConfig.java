package com.blog.configuration;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ObjectMapperConfig {
    private final ModelMapper modelMapper;
}
