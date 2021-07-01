package one.digital_innovation.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mentors extends Content {

    private LocalDateTime data;

    @Override
    public double calculateXp() {
        return XP_DEFAULT;
    }
}
