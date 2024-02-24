package ironhack.com;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person {
    private String id;
    private String name;

    public void person(String name){
        setName(name);
        setId(Utils.generateSerialId());
    }
}
