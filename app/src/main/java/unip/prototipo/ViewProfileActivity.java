package unip.prototipo;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ViewProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        loadProfileData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Recarrega os dados toda vez que a tela se torna visível
        // para garantir que as edições sejam refletidas.
        loadProfileData();
    }

    private void loadProfileData() {
        TextView tvName = findViewById(R.id.tvProfileName);
        TextView tvEmail = findViewById(R.id.tvProfileEmail);
        TextView tvPosition = findViewById(R.id.tvProfilePosition);
        TextView tvDepartment = findViewById(R.id.tvProfileDepartment);

        tvName.setText("Nome: " + UserProfileManager.getName());
        tvEmail.setText("Email: " + UserProfileManager.getEmail());
        tvPosition.setText("Cargo: " + UserProfileManager.getPosition());
        tvDepartment.setText("Departamento: " + UserProfileManager.getDepartment());
    }
}
