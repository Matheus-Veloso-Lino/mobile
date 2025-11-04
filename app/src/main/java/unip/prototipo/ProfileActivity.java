package unip.prototipo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int RESULT_GOTO_CREATE_TICKET = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Seção 1: Perfil
        findViewById(R.id.tvViewProfile).setOnClickListener(this);
        findViewById(R.id.tvEditProfile).setOnClickListener(this);
        findViewById(R.id.tvAccountSettings).setOnClickListener(this);

        // Seção 2: HelpDesk
        findViewById(R.id.tvMyTickets).setOnClickListener(this);
        findViewById(R.id.tvCreateTicket).setOnClickListener(this);

        // Seção 4: Ajuda e Suporte
        findViewById(R.id.tvContactSupport).setOnClickListener(this);
        findViewById(R.id.tvAboutApp).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tvViewProfile) {
            startActivity(new Intent(this, ViewProfileActivity.class));
        } else if (id == R.id.tvEditProfile) {
            startActivity(new Intent(this, EditProfileActivity.class));
        } else if (id == R.id.tvAccountSettings) {
            startActivity(new Intent(this, AccountSettingsActivity.class));
        } else if (id == R.id.tvMyTickets) {
            startActivity(new Intent(this, MyTicketsActivity.class));
        } else if (id == R.id.tvCreateTicket) {
            setResult(RESULT_GOTO_CREATE_TICKET);
            finish(); // Fecha a tela de perfil e envia o resultado
        } else if (id == R.id.tvContactSupport) {
            showContactSupportDialog();
        } else if (id == R.id.tvAboutApp) {
            showAboutAppDialog();
        } else {
            TextView textView = (TextView) v;
            String feature = textView.getText().toString();
            Toast.makeText(this, feature + ": Funcionalidade a ser implementada", Toast.LENGTH_SHORT).show();
        }
    }

    private void showContactSupportDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Contato com Suporte")
                .setMessage("Para obter ajuda, por favor, envie um e-mail para:\n\nsuporte.helpdesk@exemplo.com")
                .setPositiveButton("OK", null)
                .show();
    }

    private void showAboutAppDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Sobre o App")
                .setMessage("HelpDesk App\nVersão 1.0.0\n\nDesenvolvido como protótipo.")
                .setPositiveButton("OK", null)
                .show();
    }
}
