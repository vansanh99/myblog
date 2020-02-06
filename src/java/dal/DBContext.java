/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import model.Account;

/**
 *
 * @author sanhpv
 */
public class DBContext {

    Connection conn;

    public DBContext() {
    }

    public DBContext(Connection conn) {
        this.conn = conn;
    }

    public Account getAccountByUsernameAndPassword(String username, String password) throws SQLException {
        String sql = "select count(*) as count from Account where username=? and password=?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, username);
        stm.setString(2, password);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            int count = rs.getInt("count");
            if (count == 1) {
                Account account = new Account();
                account.setUsername(username);
                account.setPassword(password);
                return account;
            }
        }
        rs.close();
        return null;
    }

    public boolean isExists(String username) throws SQLException {
        String sql = "select count(username) as count from account where username=?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, username);
        ResultSet rs = stm.executeQuery();
        int count = 0;
        if (rs.next()) {
            count = rs.getInt("count");
            if (count == 1) {
                return true;
            }
        }
        rs.close();
        return false;
    }

    public void Create(String username, String password) throws SQLException {
        String sql = "insert into Account (username, password) values(?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, username);
        stm.setString(2, password);
        stm.executeUpdate();
        stm.close();
    }

    public int totalUsers() throws SQLException {
        String sql = "select count(*) as count from Account";
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        int count = 0;
        if (rs.next()) {
            count = rs.getInt("count");
        }
        rs.close();
        return count;
    }
}
