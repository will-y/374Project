package team8.coffee.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import team8.coffee.data.OrderInput;
import team8.coffee.data.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class DataBaseController {
    private static final String url = "jdbc:sqlite:src/main/resources/coffee.db";
    private Connection conn;

    public DataBaseController() {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Integer[]> capableMachines(OrderInput order) {
        try {
            String statement = "Select Machine, Controller, Type FROM capableMachine WHERE Street_Address = ? and ZIP_code = ?";
            String drink = order.getDrink();
            String street = order.getAddress().getStreet();
            int zip = order.getAddress().getZip();
            PreparedStatement sql = conn.prepareStatement(statement);
            sql.setString(1, street);
            sql.setInt(2, zip);
            ResultSet rs = sql.executeQuery();
            ArrayList<Integer[]> out = new ArrayList<>();
            boolean isProgrammable = recipe(order).size() != 0;
            boolean isAutomated = order.getOptions() != null;
            HashMap<Integer[], Boolean[]> machineType = new HashMap<>();
            while (rs.next()) {
                Integer[] machine = new Integer[]{rs.getInt("Machine"), rs.getInt("Controller")};
                Boolean[] types;
                if (!machineType.containsKey(machine))
                    machineType.put(machine, new Boolean[]{false, false, false});
                switch (rs.getString("Type")) {
                    case ("Simple"):
                        types = machineType.get(machine);
                        types[0] = true;
                        machineType.put(machine, types);
                        break;
                    case ("Automated"):
                        types = machineType.get(machine);
                        types[1] = true;
                        machineType.put(machine, types);
                        break;
                    case ("Programmable"):
                        types = machineType.get(machine);
                        types[2] = true;
                        machineType.put(machine, types);
                }
            }
            for (Integer[] machine : machineType.keySet()) {
                if (!((isProgrammable && !machineType.get(machine)[2]) || (isAutomated && !machineType.get(machine)[1])))
                    out.add(machine);
            }
//            while(rs.next()) {
//                current = new Integer[2];
//                current[0] = rs.getInt("MachineID");
//                current[1] = rs.getInt("Controller");
//                if(isProgrammable == (rs.getString("Type") == "Programmable"))
//                out.add(current);
//            }
            return out;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap<Integer, ArrayList<Integer>> controllers() {
        try {
            String sql = "Select * FROM CoffeeMakerController";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            HashMap<Integer, ArrayList<Integer>> out = new HashMap<>();
            while (rs.next()) {
                int controller = rs.getInt("Controller");
                int machine = rs.getInt("Machine");
                if (!out.containsKey(controller))
                    out.put(controller, new ArrayList<Integer>());
                ArrayList<Integer> list = out.get(controller);
                list.add(machine);
                out.put(controller, list);
            }
            return out;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public ArrayList<Recipe> recipe(OrderInput order) {
        try {
            String drink = order.getDrink();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Recipes WHERE Drink = \"" + drink + "\" ORDER BY Step");
            ArrayList<Recipe> out = new ArrayList<>();
            while (rs.next()) {
                out.add(new Recipe(rs.getString("Action"), rs.getString("Ingredient")));
            }
            return out;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
