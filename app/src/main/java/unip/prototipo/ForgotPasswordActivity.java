package unip.prototipo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        EditText edtEmailRecuperacao = findViewById(R.id.edtEmailRecuperacao);
        Button btnEnviarLink = findViewById(R.id.btnEnviarLink);

        btnEnviarLink.setOnClickListener(v -> {
            String email = edtEmailRecuperacao.getText().toString().trim();
            if (email.isEmpty()) {
                Toast.makeText(this, "Por favor, insira seu e-mail ou usuário", Toast.LENGTH_SHORT).show();
            } else {
                // Simula o envio do e-mail
                Toast.makeText(this, "Se o e-mail estiver correto, um link será enviado para: " + email, Toast.LENGTH_LONG).show();
                finish(); // Fecha a tela e volta para o login
            }
        });
    }
}
