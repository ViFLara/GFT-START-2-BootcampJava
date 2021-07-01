package one.digital_innovation.entities;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course extends Content {

    private int workload;

    @Override
    public double calculateXp() {
        return XP_DEFAULT * workload;
    }
}
