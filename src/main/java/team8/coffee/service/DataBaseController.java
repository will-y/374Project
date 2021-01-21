package team8.coffee.service;

import team8.coffee.data.OrderInput;

import java.util.ArrayList;
import java.util.HashMap;

public interface DataBaseController {
    ArrayList<Integer[]> capableMachines(OrderInput order);

    HashMap<Integer, ArrayList<Integer>> controllers();
}
