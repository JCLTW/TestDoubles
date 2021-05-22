package heima.exercises;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Vegetable {
    String name;
    String description;

    @Override
    public String toString() {
        return description.toString();
    }
}
