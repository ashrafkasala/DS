package MISCLIbrary.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Employee {
    String id;
    int score;
    String name;
}

