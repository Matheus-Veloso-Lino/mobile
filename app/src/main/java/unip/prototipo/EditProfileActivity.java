package unip.prototipo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPosition, etDepartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        etName = findViewById(R.id.etEditName);
        etEmail = findViewById(R.id.etEditEmail);
        etPosition = findViewById(R.id.etEditPosition);
        etDepartment = findViewById(R.id.etEditDepartment);
        Button btnChangePhoto = findViewById(R.id.btnChangePhoto);
        Button btnSaveChanges = findViewById(R.id.btnSaveChanges);

        loadProfileData();

        btnChangePhoto.setOnClickListener(v -> {
            Toast.makeText(this, "Funcionalidade de alterar foto a ser implementada", Toast.LENGTH_SHORT).show();
        });

        btnSaveChanges.setOnClickListener(v -> {
            saveProfileData();
            Toast.makeText(this, "Alterações salvas com sucesso!", Toast.LENGTH_SHORT).show();
            finish(); // Volta para a tela de perfil
        });
    }

    private void loadProfileData() {
        etName.setText(UserProfileManager.getName());
        etEmail.setText(UserProfileManager.getEmail());
        etPosition.setText(UserProfileManager.getPosition());
        etDepartment.setText(UserProfileManager.getDepartment());
    }

    private void saveProfileData() {
        UserProfileManager.setName(etName.getText().toString());
        UserProfileManager.setEmail(etEmail.getText().toString());
        UserProfileManager.setPosition(etPosition.getText().toString());
        UserProfileManager.setDepartment(etDepartment.getText().toString());
    }
}
