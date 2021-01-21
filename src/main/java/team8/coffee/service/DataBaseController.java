package team8.coffee.service;

import team8.coffee.data.OrderInput;

import java.util.ArrayList;
import java.util.HashMap;

public interface DataBaseController {
    ArrayList<Integer[]> capableMachines(OrderInput order);

    public ArrayList<Integer[]> capableMachines(OrderInput order) {

        String statement = "Select CoffeeMaker.MachineID, CoffeeMaker.Controller FROM capableMachines WHERE street = ? and ZIP_code = ? and capability = ?";
        String street = order.getAddress().getStreet();
        int zip = order.getAddress().getZip();
        String capability = order.getOptions() == null ? "simple" : "automated";
        PreparedStatement sql = conn.prepareStatement(statement);
        sql.setString(1, street);
        sql.setInt(2, zip);
        sql.setString(3, capability);
        ResultSet rs = sql.executeQuery();
        ArrayList<Integer[]> out = new ArrayList<>();
        int[] current;
        While(rs.next()) {
            current = new int[2];
            current[0] = rs.getInt("MachineID");
            current[1] = rs.getInt("Controller");
        }
        return out;
    }

    HashMap<Integer, ArrayList<Integer>> controllers() {
        String sql = "Select CoffeeMaker.MachineID, CoffeeMaker.Controller FROM CoffeeMaker";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        HashMap<Integer, ArrayList<Integer>> out = new HashMap<>();
        while(rs.next()) {
            int controller = rs.getInt("Controller");
            int machine = rs.getInt("MachineID");
            if(!out.containsKey(controller))
                out.put(controller, new ArrayList<Integer>());
            ArrayList<Integer> list = out.get(controller);
            list.add(machine);
            out.put(controller, list);
        }
        return out;
    }


}
