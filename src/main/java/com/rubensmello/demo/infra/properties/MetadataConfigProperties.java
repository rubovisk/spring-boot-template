package com.rubensmello.demo.infra.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "rubensmello.metadata")
public class MetadataConfigProperties {

    private String nomeAutor;

}
