package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Options {

    //Using hashmap to define the options for each questions.
    private HashMap<Integer, List<String>> options;
    public Options() {
        options = new HashMap<>();
        options.put(1, Arrays.asList("TVM", "Kochi", "Kannur", "Kollam"));
        options.put(2, Arrays.asList("Venus", "Mars", "Jupiter", "Saturn"));
        options.put(3, Arrays.asList("Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean"));
        options.put(4, Arrays.asList("Paris", "London", "Berlin", "Madrid"));
        options.put(5, Arrays.asList("Van Gogh", "Picasso", "Leonardo da Vinci", "Michelangelo"));
    }

    //To get options for each questions.
    public List<String> getOptions(int number) {
        return options.get(number);
    }
}
