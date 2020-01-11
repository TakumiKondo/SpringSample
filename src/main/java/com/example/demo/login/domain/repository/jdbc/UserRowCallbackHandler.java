package com.example.demo.login.domain.repository.jdbc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;

public class UserRowCallbackHandler implements RowCallbackHandler {

    @Override
    public void processRow(ResultSet rs) throws SQLException {

        try {
            File csvFile = new File("file.csv");
            FileWriter fileWriter = new FileWriter(csvFile.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            do {
                String csvStr = "";
                csvStr += rs.getString("id") + ",";
                csvStr += rs.getString("password") + ",";
                csvStr += rs.getString("name") + ",";
                csvStr += rs.getString("birthday") + ",";
                csvStr += rs.getString("age") + ",";
                csvStr += rs.getString("marrige") + ",";
                csvStr += rs.getString("role");
                bufferedWriter.write(csvStr);
                bufferedWriter.newLine();
            } while(rs.next());

            bufferedWriter.flush();
            bufferedWriter.close();

        } catch(IOException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
    }

}
