package unip.prototipo;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class AccountSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        SwitchMaterial switchEmail = findViewById(R.id.switchEmailNotifications);
        TextView tvLanguage = findViewById(R.id.tvLanguageSelection);

        switchEmail.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String status = isChecked ? "ativadas" : "desativadas";
            Toast.makeText(this, "Notificações por e-mail " + status, Toast.LENGTH_SHORT).show();
        });

        tvLanguage.setOnClickListener(v -> {
            Toast.makeText(this, "Funcionalidade de alterar idioma a ser implementada", Toast.LENGTH_SHORT).show();
        });
    }
}
