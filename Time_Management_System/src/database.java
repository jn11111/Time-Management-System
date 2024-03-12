import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class database {
    String projectDir = System.getProperty("user.dir");
    String url = "jdbc:sqlite:/" + projectDir + "/Time_Management_System/bin/mydatabase.db";
    targetData t;
    int id;

    private static void createDatabase(String url) {
        // Create the database
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // Execute SQL commands to create tables.
            try (BufferedReader br = new BufferedReader(
                    new FileReader("Time_Management_System//bin//createDatabase.sql"))) {
                StringBuilder sqlBuilder = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sqlBuilder.append(line).append("\n");
                }
                String[] sql = sqlBuilder.toString().split(";");
                // Now you can use the SQL string in your application?
                for (int i = 0; i < sql.length - 1; i++) {
                    stmt.execute(sql[i] + ";");
                }
                stmt.close();
                System.out.println("Created to the database!");

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error: Failed to create the database or tables
        }
    }

    public void checkDatabase() {
        // Check if the database file exists
        File file = new File(projectDir + "/Time_Management_System/bin/mydatabase.db");
        if (!file.exists()) {
            // If the database file doesn't exist, create it
            createDatabase(url);
        }
        // Connect to the database
        try (Connection conn = DriverManager.getConnection(url)) {
            // Database connection established, proceed with application logic
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DefaultTableModel getDataForAdmin(String target) {
        DefaultTableModel model = new DefaultTableModel();
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            if (conn != null) {
                // Execute SQL commands to create tables.
                String q = "";
                if (target.toString().toLowerCase() == "incomings") {
                    q = "SELECT incomings.incomingID, incomings.firstName, incomings.lastName," +
                            "incomings.email, incomings.applicationDate, getStatus.status FROM incomings " +
                            "JOIN getStatus ON incomings.statusID = getStatus.statusID;";
                } else if (target.toString().toLowerCase() == "employees") {
                    q = "Select * From employees";
                } else {
                    q = "SELECT timestamps.TimeStampID, timestamps.employeeID,timestamps.TimeIn,timestamps.TimeOut" +
                            ",timestamps.TimeStampDate,getStatus.status FROM timestamps" +
                            " JOIN getStatus ON timestamps.statusID = getStatus.statusID WHERE TIMESTAMPDATE = CURRENT_DATE;";
                }
                ResultSet rs = stmt.executeQuery(q);
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();

                // Add column names to the model
                for (int i = 1; i <= columnCount; i++) {
                    model.addColumn(rsmd.getColumnName(i));
                    // System.out.println(rsmd.getColumnName(i));
                }
                while (rs.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        row[i] = rs.getObject(i + 1);
                    }
                    model.addRow(row);
                }
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error: Failed to create the database or tables
        }
        return model;
    }

    public DefaultTableModel getDataForNonAdmin(String target, String name, String email) {
        DefaultTableModel model = new DefaultTableModel();
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            if (conn != null) {
                // Execute SQL commands to create tables.
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM '" + target + "' WHERE firstname = '" + name + "' AND email = '" + email + "'");
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                // Add column names to the model
                for (int i = 1; i <= columnCount; i++) {
                    model.addColumn(rsmd.getColumnName(i));
                }
                while (rs.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        row[i] = rs.getObject(i + 1);
                    }
                    model.addRow(row);
                }
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error: Failed to create the database or tables
        }
        return model;
    }

    public DefaultTableModel getDataForTimeStamps(String target, int id) {
        DefaultTableModel model = new DefaultTableModel();
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            if (conn != null) {
                // Execute SQL commands to create tables.
                ResultSet rs = stmt.executeQuery(
                        "SELECT timestamps.TimeStampID, timestamps.employeeID,timestamps.TimeIn,timestamps.TimeOut" +
                                ",timestamps.TimeStampDate,getStatus.status FROM timestamps" +
                                " JOIN getStatus ON timestamps.statusID = getStatus.statusID where timestamps.employeeID = '"
                                + id + "';");
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();

                // Add column names to the model
                for (int i = 1; i <= columnCount; i++) {
                    model.addColumn(rsmd.getColumnName(i));
                }
                while (rs.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        row[i] = rs.getObject(i + 1);
                    }
                    model.addRow(row);
                }
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error: Failed to create the database or tables
        }
        return model;
    }

    public DefaultTableModel getDataForApplication(String target, int id) {
        DefaultTableModel model = new DefaultTableModel();
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            if (conn != null) {
                // Execute SQL commands to create tables.
                ResultSet rs = stmt.executeQuery(
                        "SELECT incomings.incomingID, incomings.firstName, incomings.lastName, " +
                                "incomings.email, incomings.applicationDate, incomings.reason, incomings.feedback, getStatus.status FROM incomings "
                                +
                                "JOIN getStatus ON incomings.statusID = getStatus.statusID where incomings.incomingID = '"
                                + id + "';");
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();

                // Add column names to the model
                for (int i = 1; i <= columnCount; i++) {
                    model.addColumn(rsmd.getColumnName(i));
                }
                while (rs.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        row[i] = rs.getObject(i + 1);
                    }
                    model.addRow(row);
                }
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error: Failed to create the database or tables
        }
        return model;
    }

    public int getLoginStatus(String name, String email) {
        int getAccess = 0;
        int id1, id2;
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            if (conn != null) {
                // Execute SQL commands to create tables.
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM employees where firstname ='" + name + "'AND email = '" + email + "'");
                rs.next();
                id1 = rs.getInt(1);
                int getCount = rs.getInt(1);
                if (rs.getInt("adminaccess") == 1) {
                    getAccess += 1;
                }
                ResultSet rs1 = stmt.executeQuery(
                        "SELECT * FROM incomings where firstname ='" + name + "'AND email = '" + email + "'");
                rs1.next();
                int getCount1 = rs1.getInt(1);
                id2 = rs1.getInt(1);
                this.id = getCount > 0 ? id1 : getCount1 > 0 ? id2 : 0;
                System.out.println("FROM LOGIN " + this.id);
                if (getCount > 0 || getCount1 > 0) {
                    getAccess += 1;
                }
                this.t = getCount > 0 ? targetData.Employees : getCount1 > 0 ? targetData.Incomings : targetData.empty;
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error: Failed to create the database or tables
        }
        return getAccess;
    }

    public boolean TimeIN(int id) {
        boolean getEntry = false;
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            if (conn != null) {
                // Execute SQL commands to create tables.
                ResultSet rs = stmt.executeQuery(
                        "SELECT TIMESTAMPDATE FROM timestamps where employeeid = '" + id
                                + "' AND TIMESTAMPDATE = CURRENT_DATE");
                while (rs.next()) {
                    getEntry = rs.getString("TIMESTAMPDATE") != null ? true : false;
                    System.out.println(rs.getString("TIMESTAMPDATE") + getEntry);
                }
                System.out.println(getEntry);
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error: Failed to create the database or tables
        }
        return !getEntry;
    }

    public boolean TimeOut(int empid, int timeID) {
        boolean getEntry = true;
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            if (conn != null) {
                // Execute SQL commands to create tables.
                ResultSet rs = stmt.executeQuery(
                        "SELECT timeout, timestampid FROM timestamps where employeeid = '" + empid
                                + "' AND TIMESTAMPDATE = CURRENT_DATE AND timestampID = '" + timeID + "'");
                while (rs.next()) {
                    getEntry = rs.getString("timeout") != null ? true : false;
                    System.out.println("ew" + rs.getString("timeout") + getEntry);
                }
                System.out.println(getEntry);
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error: Failed to create the database or tables
        }
        return getEntry;
    }

    public void InsertTimeIN(int id) {
        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO timestamps (employeeID) values ('" + id + "')")) {
            if (conn != null) {
                // Execute SQL commands to create tables.
                stmt.executeUpdate();
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error: Failed to create the database or tables
        }
    }

    public void InsertTimeOut(int id) {
        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE timestamps set timeout = current_time where timestampID = '" + id + "'")) {
            if (conn != null) {
                // Execute SQL commands to create tables.
                stmt.executeUpdate();
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error: Failed to create the database or tables
        }
    }

    public void updateApplication(String firstname, String lastname, String email, String reason,
            int id) {
        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE incomings set firstname = '" + firstname + "', " +
                                "lastname = '" + lastname + "', email = '" + email + "', reason = '" + reason + "' " +
                                "where incomingID = '" + id + "'")) {
            if (conn != null) {
                // Execute SQL commands to create tables.
                stmt.executeUpdate();
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error: Failed to create the database or tables
        }
    }

    public void changeIncomingStatus(int id, int status, String fname, String lname, String email) {
        try (Connection connection = DriverManager.getConnection(url);
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE INCOMINGS SET statusID = '" + status + "' WHERE INCOMINGID = '" + id + "'")) {
            if (connection != null) {
                statement.executeUpdate();
                if (status == 2) {
                    try (Connection connection2 = DriverManager.getConnection(url);
                            PreparedStatement statement2 = connection2.prepareStatement(
                                    "INSERT INTO EMPLOYEES (FIRSTNAME, LASTNAME, EMAIL, EMPLOYMENTDATE) " +
                                            "VALUES('" + fname + "', '" + lname + "', '" + email
                                            + "', CURRENT_DATE);")) {
                        statement2.executeUpdate();
                        statement2.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeTimestampsStatus(int id, int status) {
        try (Connection connection = DriverManager.getConnection(url);
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE TIMESTAMPS SET statusID = '" + status + "' WHERE TIMESTAMPID = '" + id + "'")) {
            if (connection != null) {
                statement.executeUpdate();
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void newIncoming(String fname, String lname, String email, String reason) {
        try (Connection connection = DriverManager.getConnection(url);
                PreparedStatement statement = connection
                        .prepareStatement("INSERT INTO INCOMINGS(firstname, lastname, email, reason) " +
                                "VALUES ('" + fname + "', '" + lname + "', '" + email + "', '" + reason + "');")) {
            if (connection != null) {
                statement.executeUpdate();
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTarget() {
        return t.name();
    }

    public int getCurrentID() {
        System.out.println("FROM DATABASE " + this.id);
        return this.id;
    }
}
