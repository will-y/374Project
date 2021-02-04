package team8.coffee.data.command;

public abstract class RecipeDecorator implements Command {
    private Command command;

    public RecipeDecorator(Command command) {
        this.command = command;
    }

    @Override
    public String recipe() {
        return command.recipe();
    }
}
