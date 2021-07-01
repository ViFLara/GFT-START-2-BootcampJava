package one.digital_innovation.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bootcamp {

    private String name;
    private LocalDate beginning;
    private LocalDate end;
    private List<Content> contents = new ArrayList<>();
    private List<Developer> developers = new ArrayList<>();
}
