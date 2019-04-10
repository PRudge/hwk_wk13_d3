package com.codeclan.example.WhiskyTracker.projections;
import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;

import org.springframework.data.rest.core.config.Projection;


@Projection(name = "embedDistillery", types =Whisky.class)
public interface EmbedDistillery {
    String getName();
    int getYear();
    int getAge();

   Distillery getDistillery();
}
