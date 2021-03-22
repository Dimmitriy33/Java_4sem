package by.shalunov.one;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.*;
import java.util.ArrayList;


public class Main {

    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=PlanetsDatabase";

    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        Statement stmt = null;
        Savepoint beginPoint = new Savepoint() {
            @Override
            public int getSavepointId() throws SQLException {
                return 0;
            }

            @Override
            public String getSavepointName() throws SQLException {
                return null;
            }
        };

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            conn = DriverManager.getConnection(DB_URL, "Dmitriy", "q1w2e3r4t5");
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            beginPoint =  conn.setSavepoint("beginPoint");

            //task 1
            {
                String sql = "SELECT Name FROM Planets WHERE Live='Yes';";

                ResultSet rs = stmt.executeQuery(sql);

                ArrayList<String> MyPlanets = new ArrayList<>();

                System.out.println("------------------");
                System.out.println("Планеты, где есть жизнь");
                while (rs.next()) {
                    String name = rs.getString("Name");
                    MyPlanets.add(name);

                    System.out.printf("Name: %s\n", name);
                    conn.commit();
                }


                System.out.println("\nИх спутники");
                for (int i = 0; i < MyPlanets.size(); i++) {
                    String sql2 = "SELECT * FROM Satellites WHERE PlanetName = \'"+ MyPlanets.get(i)+"\';";

                    ResultSet rs2 = stmt.executeQuery(sql2);

                    while (rs2.next()) {
                        String satellite = rs2.getString("Name");
                        String planetName = rs2.getString("PlanetName");

                        System.out.printf("Name: %s, Planet name: %s\n", satellite, planetName);
                    }
                }
                System.out.println("------------------");
                conn.commit();
            }

            //task 2
            {

                //TODO: task 2 and 3 and logger
                ResultSet rs3 = stmt.executeQuery(
                        "select top(3) Planets.Atmosphere, Planets.CoreTemperature, Planets.Live, Planets.Name, Planets.Radius, Satellites.Name, Satellites.PlanetDistance, Satellites.Radius\n" +
                                "from Planets inner join Satellites\n" +
                                "on Planets.Name=Satellites.PlanetName\n" +
                                "ORDER BY Satellites.Radius DESC;");

                while (rs3.next()) {
                    System.out.println(
                            "Planet:  " + rs3.getString(2) +
                            " " +
                            rs3.getString(3) +
                            " " +
                            rs3.getString(4) +
                            " " +
                            rs3.getString(5) +
                            " " +
                            rs3.getString(6) +
                            " " +
                            rs3.getString(8));
                }
                conn.commit();
            }

            //task 3
            {
                String sql4 = "SELECT * FROM Planets;";
                ResultSet rs4 = stmt.executeQuery(sql4);

                float radius = 0f;
                float maxRadius = 0f;
                String planet = "";

                ArrayList<String > MyPlanets = new ArrayList<>();

                while(rs4.next()){

                    //System.out.println(rs4.getString("Name"));
                    MyPlanets.add(rs4.getString("Name"));
                }

                String sql5 = "SELECT * FROM Satellites;";
                ResultSet rs5 = stmt.executeQuery(sql5);


                for(int i = 0; i < MyPlanets.size(); i++){

                    while(rs5.next()){
                        if((planet = rs5.getString("PlanetName")).equals(MyPlanets.get(i))){
                            radius += rs5.getFloat("Radius");
                        }

                        if(radius > maxRadius){
                            maxRadius = radius;
                        }

                        radius = 0;
                    }

                }

                System.out.println(planet);
                conn.commit();
            }

        } catch (SQLException | ClassNotFoundException e) {
            conn.rollback(beginPoint);
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }


    }
}
