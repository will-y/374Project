package team8.coffee.service;

import team8.coffee.data.OrderInput;
import team8.coffee.data.Recipe;

import java.util.ArrayList;
import java.util.HashMap;

public interface DatabaseController {
    ArrayList<Integer[]> capableMachines(OrderInput order);
    HashMap<Integer, ArrayList<Integer>> controllers();
    ArrayList<Recipe> recipe(OrderInput order);
}
