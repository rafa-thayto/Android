package informatica.sp.senai.br.cadastroinutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgPessoa;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        rgPessoa = findViewById(R.id.rgPessoa);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rgPessoa.getCheckedRadioButtonId()) {
                    case R.id.rbPessoaFisica:

                        break;
                    case R.id.rbPessoaJuridica:

                        break;
                }
            }
        });
    }
}
