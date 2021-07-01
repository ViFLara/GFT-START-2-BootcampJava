package one.digital_innovation.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Developer {

    private String name;
    private List<Content> subscribedContents = new ArrayList<>();
    private List<Content> completedContents = new ArrayList<>();
    private Content content;

    public void signUp(Content content) {
        if (subscribedContents.contains(content)) {
            System.out.println("You have already subscribed to this content");
        } else {
            subscribedContents.add(content);
        }
    }

    public void signUp(Bootcamp bootcamp) {
        // Alternative 1 streamAPI
        // bootcamp.getContents().stream().forEach(this::signUp);
        // Alternative 2 traditional foreach
        for (Content content: bootcamp.getContents()) {
            signUp(content);
        }
        bootcamp.getDevelopers().add(this);
    }

    public void progress() {
       Optional<Content> content = subscribedContents.stream().findFirst();
       if (content.isPresent()) {
           completedContents.add(content.get());
           subscribedContents.remove(content);
       } else {
           System.out.println("You are not subscribed in content");
       }
    }

    public double calculateTotalXp() {
        return completedContents.stream()
                .mapToDouble(Content::calculateXp)
                .sum();
    }
}
