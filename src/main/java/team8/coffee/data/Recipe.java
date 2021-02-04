package team8.coffee.data;

public class Recipe {
    String commandStep;
    String object;

    public Recipe(String commandStep, String object) {
        this.commandStep = commandStep;
        this.object = object;
    }

    public String getCommandStep() {
        return commandStep;
    }

    public void setCommandStep(String commandStep) {
        this.commandStep = commandStep;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
