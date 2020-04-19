import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Selects {
    private Statement statement;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    Selects(Statement statement) {
        this.statement = statement;
    }

    void select1() {
        System.out.println("Type department name: ");
        try {
            String depName = reader.readLine();
            System.out.println("Select#1: results");
            if ((!depName.isEmpty()) && (!depName.isBlank())) {
                String SQL = "SELECT S.ID, S.FULL_NAME, S.SALARY \n" +
                        "FROM STAFF S \n" +
                        "JOIN DEPARTMENTS D ON S.DEP_ID = D.ID \n" +
                        "WHERE D.NAME=UPPER('" + depName + "') \n" +
                        "ORDER BY S.SALARY";
                ResultSet resultSet = statement.executeQuery(SQL);
                String str = "ID, FULL_NAME, SALARY";
                System.out.println(str);
                int count = 0;
                while (resultSet.next()) {
                    str = String.valueOf(resultSet.getInt(1));
                    str = str + ", ";
                    str = str + resultSet.getString(2);
                    str = str + ", ";
                    str = str + resultSet.getInt(3);
                    System.out.println(str);
                    count++;
                }
                System.out.println("---------------");
                if (0 == count) {
                    System.out.println("No rows found");
                } else {
                    System.out.println(count + " row(s) found");
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }


    void select2() {
        System.out.println("Type department name: ");
        try {
            String depName = reader.readLine();
            System.out.println("Select#2: results");
            if ((!depName.isEmpty()) && (!depName.isBlank())) {
                String SQL = "SELECT S.ID, S.FULL_NAME, S.SALARY \n" +
                        "FROM STAFF S \n" +
                        "JOIN DEPARTMENTS D ON S.DEP_ID = D.ID \n" +
                        "WHERE D.NAME=UPPER('" + depName + "') \n" +
                        "ORDER BY S.FULL_NAME";
                ResultSet resultSet = statement.executeQuery(SQL);
                String str = "ID, FULL_NAME, SALARY";
                System.out.println(str);
                int count = 0;
                while (resultSet.next()) {
                    str = String.valueOf(resultSet.getInt(1));
                    str = str + ", ";
                    str = str + resultSet.getString(2);
                    str = str + ", ";
                    str = str + resultSet.getInt(3);
                    System.out.println(str);
                    count++;
                }
                System.out.println("---------------");
                if (0 == count) {
                    System.out.println("No rows found");
                } else {
                    System.out.println(count + " row(s) found");
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    void select3() {
        System.out.println("Type input salary: ");
        try {
            int salary = Integer.parseInt(reader.readLine());
            System.out.println("Select#3: results");
            String SQL = "SELECT S.ID, S.FULL_NAME, S.SALARY\n" +
                    "FROM STAFF S\n" +
                    "WHERE S.SALARY > " + salary;
            ResultSet resultSet = statement.executeQuery(SQL);
            String str = "ID, FULL_NAME, SALARY";
            System.out.println(str);
            int count = 0;
            while (resultSet.next()) {
                str = String.valueOf(resultSet.getInt(1));
                str = str + ", ";
                str = str + resultSet.getString(2);
                str = str + ", ";
                str = str + resultSet.getInt(3);
                System.out.println(str);
                count++;
            }
            System.out.println("---------------");
            if (0 == count) {
                System.out.println("No rows found");
            } else {
                System.out.println(count + " row(s) found");
            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    void select4() {
        System.out.println("Type staff full name: ");
        try {
            String name = reader.readLine();
            System.out.println("Select#4: results");
            String SQL = "SELECT S.SALARY, D.ID \n" +
                    "FROM STAFF S\n" +
                    "LEFT JOIN DEPARTMENTS D ON D.HEAD = S.ID \n" +
                    "WHERE S.FULL_NAME = UPPER('" + name + "')";
            ResultSet resultSet = statement.executeQuery(SQL);
            int count = 0;
            while (resultSet.next()) {
                count++;
                int salary = resultSet.getInt(1);
                int depId = resultSet.getInt(2);
                if (depId > 0) {
                    SQL = "SELECT S.ID, S.FULL_NAME, S.SALARY \n" +
                            "FROM STAFF S \n" +
                            "JOIN DEPARTMENTS D ON S.DEP_ID = D.ID \n" +
                            "WHERE D.ID=" + depId + " \n" +
                            "ORDER BY S.FULL_NAME";
                    resultSet = statement.executeQuery(SQL);
                    String str = "ID, FULL_NAME, SALARY";
                    System.out.println(str);
                    int count2 = 0;
                    while (resultSet.next()) {
                        str = String.valueOf(resultSet.getInt(1));
                        str = str + ", ";
                        str = str + resultSet.getString(2);
                        str = str + ", ";
                        str = str + resultSet.getInt(3);
                        System.out.println(str);
                        count2++;
                    }
                    System.out.println("---------------");
                    if (0 == count2) {
                        System.out.println("No rows found");
                    } else {
                        System.out.println(count2 + " row(s) found");
                    }
                } else {
                    System.out.println("SALARY");
                    System.out.println(salary);
                    System.out.println("---------------");
                    System.out.println(1 + " row(s) found");
                }
            }
            if (0 == count) {
                System.out.println("No rows found");
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }


}
