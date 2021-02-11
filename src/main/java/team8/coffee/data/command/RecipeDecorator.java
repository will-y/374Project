package team8.coffee.data.command;

//Here is where we use decorator pattern, to help us deal with recipes
public abstract class RecipeDecorator implements Command {
    private Command command;

    public RecipeDecorator(Command command) {
        this.command = command;
    }

    @Override
    public String recipe() {
        return command.recipe();
    }

    @Override
    public String toString() {
        return command.toString();
    }
}
