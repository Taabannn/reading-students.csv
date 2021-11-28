package ir.maktab58.decoratorq2.imagereader.client;

/**
 * @author Taban Soleymani
 */
public class User {
    private String name;
    private String choices;

    public User(String name, String choices) {
        this.name = name;
        this.choices = choices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }
}
