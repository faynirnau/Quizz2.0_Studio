package com.example.quizz20.modele;

import android.os.AsyncTask;
import android.util.Log;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;


public class Bdd extends AsyncTask<String, Void, String> {

    String res;
    @Override
    protected String doInBackground(String... strings) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/quizz", "root","root");
            String result = "Database Connection Successful\n";
            Log.d("BDD", "doInBackground: Connection Reussite");
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery("select * from quizz.question");
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()){
                result += rs.getString(1).toString()+"\n";
            }
            res = result;
            Log.d("BDD", "doInBackground: "+res);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return res;
    }
}
