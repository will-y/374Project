package team8.coffee.data.command;

public class SimpleRecipeDecorator extends RecipeDecorator {
    String step;

    public SimpleRecipeDecorator(Command command, String step) {
        super(command);
        this.step = step;
    }

    @Override
    public String recipe() {
        return super.recipe() + "{\"commandstep\": \"" + step + "\"},";
    }
}
