package org.example.domain;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Item {

    private String name;
    private String searchTags;
    private String description;
    private Double price;

    private LocalDate localDate;
}
