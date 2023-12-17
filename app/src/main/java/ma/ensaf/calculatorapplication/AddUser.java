package ma.ensaf.calculatorapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddUser extends AppCompatActivity {

    EditText username,password,email;
    Button adduser;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adduser);


        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);
        adduser=findViewById(R.id.Adduser);

        DB= new DBHelper(this);

        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= username.getText().toString();
                String pass=password.getText().toString();
                String mail=email.getText().toString();

                if(user.equals("") || pass.equals("") || mail.equals(""))
                {
                    Toast.makeText(AddUser.this, "please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean checkuser= DB.checkusernamePassword(user,pass);
                    if(checkuser==true){
                        Toast.makeText(AddUser.this, "user already Exists", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        DB.InsertData(user,pass,mail);
                        Intent intent = new Intent(AddUser.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

    }
}
