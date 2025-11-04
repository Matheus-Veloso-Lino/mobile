package unip.prototipo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainScreenActivity extends AppCompatActivity {

    private ViewPager2 viewPager;

    // Novo launcher para esperar o resultado da ProfileActivity
    private final ActivityResultLauncher<Intent> profileLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == ProfileActivity.RESULT_GOTO_CREATE_TICKET) {
                    // Muda para a segunda aba (índice 1)
                    if (viewPager != null) {
                        viewPager.setCurrentItem(1);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        TextView tvUserName = findViewById(R.id.tvUserName);
        ImageView ivUserProfile = findViewById(R.id.ivUserProfile);
        Button btnLogout = findViewById(R.id.btnLogout);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager); // Atribui o viewPager da classe

        String userName = getIntent().getStringExtra("USER_NAME");
        if (userName != null && !userName.isEmpty()) {
            tvUserName.setText("Usuário: " + userName);
        }

        // Adapter das abas
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(position == 0 ? "Chamados" : "Criar Chamado")
        ).attach();

        ivUserProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainScreenActivity.this, ProfileActivity.class);
            profileLauncher.launch(intent); // Inicia a activity esperando um resultado
        });

        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(MainScreenActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}