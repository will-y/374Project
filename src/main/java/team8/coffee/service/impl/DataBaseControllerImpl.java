package team8.coffee.service.impl;
import org.springframework.stereotype.Service;
import team8.coffee.data.OrderInput;
import team8.coffee.service.DataBaseController;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class DataBaseControllerImpl implements DataBaseController {
    private static final String url = "jdbc:sqlite:C:\\Users\\wootenjt\\Documents\\CSSE374\\M2\\coffee.db";
    private Connection conn;

    public DataBaseControllerImpl() {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ;
    }

    public ArrayList<Integer[]> capableMachines(OrderInput order) {
        try {
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
            Integer[] current;
            while(rs.next()) {
                current = new Integer[2];
                current[0] = rs.getInt("MachineID");
                current[1] = rs.getInt("Controller");
                out.add(current);
            }
            return out;
        } catch (SQLException e) {
            return null;
        }

    }

    public HashMap<Integer, ArrayList<Integer>> controllers() {
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
