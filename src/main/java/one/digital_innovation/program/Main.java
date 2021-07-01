package one.digital_innovation.program;

import one.digital_innovation.entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Course basicJava = new Course();
        basicJava.setTitle("Basic Java");
        basicJava.setDescription("Learn basics Java concepts");
        basicJava.setWorkload(8);

        Course dotNetCourse = new Course();
        dotNetCourse.setTitle("Basic .Net");
        dotNetCourse.setDescription("Learn basics of C#");
        dotNetCourse.setWorkload(8);

        Course advancedJava = new Course();
        advancedJava.setTitle("Advanced Java");
        advancedJava.setDescription("Learn advanced Java concepts");
        advancedJava.setWorkload(8);

        Mentors mentors = new Mentors();
        mentors.setTitle("Learning object orientation with Java");
        mentors.setDescription("Immersion on the pillars of object orientation");
        mentors.setData(LocalDateTime.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName("GFT START #2 Java");
        bootcamp.setBeginning(LocalDate.now());
        bootcamp.setEnd(bootcamp.getBeginning().plusDays(45));
        List<Content> contentsBootcamp = Arrays.asList(basicJava, advancedJava, mentors);
        bootcamp.setContents(contentsBootcamp);

        Developer viviane = new Developer();
        viviane.setName("Viviane");

        Developer bianca = new Developer();
        bianca.setName("Bianca");

        viviane.signUp(dotNetCourse);
        viviane.signUp(bootcamp);
        viviane.progress();
        viviane.progress();

        bianca.signUp(bootcamp);
        bianca.progress();

        System.out.println(String.format("XP Viviane: %.2f", viviane.calculateTotalXp()));
        System.out.println(String.format("XP Bianca: %.2f", bianca.calculateTotalXp()));

        List<Developer> ranking = Arrays.asList(viviane, bianca).stream()
                .sorted((dev1, dev2) -> Double.compare(dev2.calculateTotalXp(), dev1.calculateTotalXp()))
                .collect(Collectors.toList());

        for (Developer dev: ranking) {
            System.out.println(dev.getName());
        }
    }
}
