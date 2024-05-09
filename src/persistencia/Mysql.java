package persistencia;

public class Mysql {

    public static String select = "SELECT * FROM ";
    public static String SelectWhere = "";

    public static String Insert = "INSERT INTO ";
    public static String Update = "UPDATE ";

    public static void tabla(String table) {
        select = select + table + " ";
        SelectWhere = select + table + " " + " WHERE ";
        Insert = Insert + table + " ";
        Update = Update + table + " ";

    }
}
