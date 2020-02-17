package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tp3.db.MyDatabase;
import com.example.tp3.db.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    static User user = new User();
    static MyDatabase mydatabase;
    Button connecter;
    EditText login;
    EditText pass;
    TextView Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void myClick(View v) {
        connecter = this.findViewById(R.id.button);
        login = this.findViewById(R.id.login);
        pass = this.findViewById(R.id.pass);
        Text = this.findViewById(R.id.nouv);
        mydatabase = Room.databaseBuilder(getApplicationContext(),MyDatabase.class, "user_bd").allowMainThreadQueries().build() ;
        user.login = login.getText().toString();
        user.pass = pass.getText().toString();

        if ( !(login.getText().toString()).matches("")) {
            List<User> usr = MainActivity.mydatabase.mydao().getUser(login.getText().toString());
            switch (v.getId()) {
                case R.id.nouv:
                    if (usr.size() != 0) {
                        Toast.makeText(getApplicationContext(), "Impossible de créer le compte: login existant", Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        MainActivity.mydatabase.mydao().adduser(user);
                        Toast.makeText(getApplicationContext(), "Parfait le compte est crée", Toast.LENGTH_SHORT).show();
                        break;
                    }
                case R.id.button:
                    if (usr.size() != 0) {
                        if (usr.get(0).pass.contentEquals(pass.getText().toString()) ) {
                            Intent intent = new Intent(this, Mylist.class);
                            startActivity(intent);
                            break;
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Mot de passe incorrect", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Compte non existant", Toast.LENGTH_SHORT).show();
                        break;
                    }
            }
        }
    }

    public void Connexion(View view) {
        myClick(view);
    }
}
