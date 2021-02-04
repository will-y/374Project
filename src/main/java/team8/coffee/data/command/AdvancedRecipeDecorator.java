package team8.coffee.data.command;

public class AdvancedRecipeDecorator extends RecipeDecorator {
    String step;
    String object;

    public AdvancedRecipeDecorator(Command command, String step, String object) {
        super(command);
        this.step = step;
        this.object = object;
    }

    @Override
    public String recipe() {
        return super.recipe() + "{\"commandstep\": \"" + step + "\", \"object\": \"" + object + "\"},";
    }
}
