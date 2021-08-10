package Apps;

//import com.mysql.jdbc.Driver;
//import entities.Artist;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import services.ArtistRepo;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import java.sql.*;
//import java.util.StringJoiner;
//




//@SpringBootApplication
//public class jpaApplication




//    static void executeStatement(Connection connection, String sqlStatement) {
//        try {
//            Statement statement = getScrollableStatement(connection);
//            statement.execute(sqlStatement);
//           //connection.setAutoCommit(false);
//            connection.commit();
//        } catch (SQLException e) {
//            throw new Error(e);
//        }
//    }
//
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(jpaApplication.class, args);
//        registerJDBCDriver();
//        Connection mysqlDbConnection = getConnection("mysql");
//        ArtistRepo artistrepo = new ArtistRepo(mysqlDbConnection);
//
//        executeStatement(mysqlDbConnection, "CREATE DATABASE IF NOT EXISTS manager;");
//        executeStatement(mysqlDbConnection, "USE manager;");
//
//
//        executeStatement(mysqlDbConnection, new StringBuilder()
//                .append("CREATE TABLE IF NOT EXISTS  manager.artist(")
//                .append("id int auto_increment primary key,")
//                .append("name text not null,")
//                .append("stage_name text not null,")
//                .append("numOfAwards int);" )
//                .toString());
//         artistrepo.create(new Artist(1L , "yoongi", "suga", 6789));
//         artistrepo.create(new Artist(2L, "benito", "badbunny", 2345));
//        System.out.println(artistrepo.readAll());
//
//
//        String getArtistTable = "SELECT * FROM manager.artist;";
//        ResultSet resultSet = executeQuery(mysqlDbConnection, getArtistTable);
//        printResults(resultSet);
//
//
//        resultSet = executeQuery(mysqlDbConnection, getArtistTable);
//        printResults(resultSet);
//    }
//
//    static ResultSet executeQuery(Connection connection, String sqlQuery) {
//        try {
//            Statement statement = getScrollableStatement(connection);
//            return statement.executeQuery(sqlQuery);
//        } catch (SQLException e) {
//            throw new Error(e);
//        }
//    }
//
//
//    static void printResults(ResultSet resultSet) {
//        try {
//            for (int rowNumber = 0; resultSet.next(); rowNumber++) {
//                String firstColumnData = resultSet.getString(1);
//                String secondColumnData = resultSet.getString(2);
//                String thirdColumnData = resultSet.getString(3);
//                System.out.println(new StringJoiner("\n")
//                        .add("Row number = " + rowNumber)
//                        .add("First Column = " + firstColumnData)
//                        .add("Second Column = " + secondColumnData)
//                        .add("Third column = " + thirdColumnData));
//            }
//        } catch (SQLException e) {
//            throw new Error(e);
//        }
//    }
//
//    static void registerJDBCDriver() {
//        // Attempt to register JDBC Driver
//        try {
//            DriverManager.registerDriver(Driver.class.newInstance());
//        } catch (InstantiationException | IllegalAccessException | SQLException e1) {
//            throw new RuntimeException(e1);
//        }
//    }
//
//    static Statement getScrollableStatement(Connection connection) {
//        int resultSetType = ResultSet.TYPE_SCROLL_INSENSITIVE;
//        int resultSetConcurrency = ResultSet.CONCUR_READ_ONLY;
//        try { // scrollable statements can be iterated more than once without closing
//            return connection.createStatement(resultSetType, resultSetConcurrency);
//        } catch (SQLException e) {
//            throw new Error(e);
//        }
//    }
//
//
//    static Connection getConnection(String dbVendor) {
//        String username = "laura";
//        String password = "zipcode0";
//        String url = new StringBuilder()
//                .append("jdbc:")
//                .append(dbVendor)
//                .append("://127.0.0.1/")
//                .append("?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
//                .toString();
//        try {
//            return DriverManager.getConnection(url, username, password);
//        } catch (SQLException e) {
//            throw new Error(e);
//        }
//    }
//
//
//}


//                .append("INSERT INTO manager.artist(")
//                .append("id, name, stageName, numOfAwards) ")
//                .append("VALUES (1L, 'yoongi', 'suga', '6789');")
//                .toString());

//        executeStatement(mysqlDbConnection, new StringBuilder()
//                .append("INSERT INTO manager.artist(")
//                .append("\"id, name, stageName, numOfAwards) ")
//                .append("VALUES (2L, 'benito', 'badBunny', '2345');")
//                .toString());
//