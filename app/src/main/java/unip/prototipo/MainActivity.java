package unip.prototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);

        EditText editTextUser = findViewById(R.id.editTextUser);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(v -> {
            String user = editTextUser.getText().toString();
            String password = editTextPassword.getText().toString();

            if (user.equals("admin") && password.equals("123456")) {
                Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, MainScreenActivity.class);
                startActivity(intent);
                finish();
                // Aqui você pode abrir outra tela se quiser
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


