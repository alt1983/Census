import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        Stream<Person> streamAges = persons.stream();
        long i = streamAges.filter(x -> x.getAge() < 18).count();
        Stream<Person> streamWarriors = persons.stream();
        List<String> warriors = streamWarriors.filter(x -> x.getSex().equals(Sex.MAN)).filter(x -> ((x.getAge() >= 18) && (x.getAge() <= 27))).map(Person::getName).collect(Collectors.toList());
        Stream<Person> streamWorkers = persons.stream();
        List<String> workers = streamWorkers.filter(x -> x.getAge() >= 18).filter(x -> x.getEducation().equals(Education.HIGHER)).map(Person::getName).sorted(Comparator.naturalOrder()).collect(Collectors.toList());

    }
}
