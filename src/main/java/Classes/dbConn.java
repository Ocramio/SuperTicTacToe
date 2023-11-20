// 
// Decompiled by Procyon v0.5.36
// 

package Classes;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public class dbConn
{
    public Connection getConnection() throws SQLException {
        final String DB_URL = "jdbc:mysql://localhost:3306/?user=root";
        final String USERNAME = "root";
        final String PASSWORD = "*Marco490182";
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root", "root", "*Marco490182");
            stmt = conn.createStatement();
            final String dbSelect = "USE db;";
            stmt.execute(dbSelect);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public String pegarLetra(final int id) throws SQLException {
        final PreparedStatement ps = this.getConnection().prepareStatement("SELECT letra FROM super_tic_tac_toe WHERE id = ?;");
        ps.setInt(1, id);
        final ResultSet rs = ps.executeQuery();
        rs.next();
        final String letra = rs.getString(1);
        return letra;
    }
    
    public void setLetra(final String letra, final int id) throws SQLException {
        final PreparedStatement ps = this.getConnection().prepareStatement("UPDATE super_tic_tac_toe SET letra = ? WHERE id = ?;");
        ps.setString(1, letra);
        ps.setInt(2, id);
        ps.execute();
    }
    
    public void resetarJogo() throws SQLException {
        final PreparedStatement ps = this.getConnection().prepareStatement("UPDATE super_tic_tac_toe SET letra = NULL;");
        ps.execute();
    }
}
