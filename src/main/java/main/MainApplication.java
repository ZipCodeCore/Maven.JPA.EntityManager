//package main;
//
//import entities.Artist;
//import entities.Painting;
//import services.ArtistRepository;
//import services.PaintingRepository;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.StringJoiner;
//
//public class MainApplication {
//
//    public static void main(String[] args) {
//        SQLConnect.registerJDBCDriver();
//        Connection mysqlDbConnection = SQLConnect.getConnection("mysql");
//        ArtistRepository artistRepository = new ArtistRepository(mysqlDbConnection);
//        PaintingRepository paintingRepository = new PaintingRepository(mysqlDbConnection);
//        executeStatement(mysqlDbConnection, "DROP DATABASE IF EXISTS artdb;");
//        executeStatement(mysqlDbConnection, "CREATE DATABASE IF NOT EXISTS artdb;");
//        executeStatement(mysqlDbConnection, "USE artdb;");
//        executeStatement(mysqlDbConnection, new StringBuilder()
//                .append("CREATE TABLE IF NOT EXISTS artdb.artists(")
//                .append("id int auto_increment primary key,")
//                .append("name text not null,")
//                .append("birth_place text not null,")
//                .append("birth_year int);")
//                .toString());
//        executeStatement(mysqlDbConnection, new StringBuilder()
//                .append("CREATE TABLE IF NOT EXISTS artdb.paintings(")
//                .append("id int auto_increment primary key,")
//                .append("title text not null,")
//                .append("medium text not null,")
//                .append("artist text not null);")
//                .toString());
//
//        artistRepository.create(new Artist(1L, "Edward Hopper", "New York", 1882));
//        artistRepository.create(new Artist(2L, "Vincent van Gogh", "Netherlands", 1853));
//        paintingRepository.create(new Painting(1L, "Nighthawks", "oil", "Edward Hopper"));
//        paintingRepository.create(new Painting(2L, "Almond Blossom", "oil", "Vincent van Gogh"));
//        System.out.println(artistRepository.findAll());
//        System.out.println(paintingRepository.findAll());
//
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
//    static void executeStatement(Connection connection, String sqlStatement) {
//        try {
//            Statement statement = getScrollableStatement(connection);
//            statement.execute(sqlStatement);
//        } catch (SQLException e) {
//            throw new Error(e);
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
//}
