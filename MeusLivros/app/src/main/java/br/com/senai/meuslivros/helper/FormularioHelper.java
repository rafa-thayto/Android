package br.com.senai.meuslivros.helper;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import br.com.senai.meuslivros.FormularioActivity;
import br.com.senai.meuslivros.R;
import br.com.senai.meuslivros.model.Livro;

/**
 * Created by adminLocal on 11/04/2018.
 */

public class FormularioHelper {
    private ImageView capaDoLivro;
    private EditText tituloDoLivro;
    private EditText autorDoLivro;
    private Button botaoCadastrar;
    private Livro livro;

    public ImageView getCapaDoLivro() {
        return capaDoLivro;
    }

    public void setCapaDoLivro(ImageView capaDoLivro) {
        this.capaDoLivro = capaDoLivro;
    }

    public Button getBotaoCadastrar() {
        return botaoCadastrar;
    }

    public void setBotaoCadastrar(Button botaoCadastrar) {
        this.botaoCadastrar = botaoCadastrar;
    }

    public FormularioHelper(FormularioActivity formulario) {
        capaDoLivro = formulario.findViewById(R.id.imgLivro);
        tituloDoLivro = formulario.findViewById(R.id.editTitulo);
        autorDoLivro = formulario.findViewById(R.id.editAutor);
        botaoCadastrar = formulario.findViewById(R.id.btnCadastrar);
        livro = new Livro();
    }

    public Livro pegaLivro() {
        livro.setCaminhoDaCapa(capaDoLivro.getTag().toString());
        livro.setTituloDoLivro(tituloDoLivro.getText().toString());
        livro.setAutorDoLivro(autorDoLivro.getText().toString());
        return livro;
    }
}
