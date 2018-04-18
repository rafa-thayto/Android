package informatica.sp.senai.br.usandofragments

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoTrocar = findViewById<Button>(R.id.btnTrocarFragments)
        var status = true
        botaoTrocar.setOnClickListener({
            var fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            if (status) {
                var loginFragment: LoginFragment = LoginFragment()
                fragmentTransaction.replace(R.id.container_fragments, loginFragment)
                fragmentTransaction.commit()
                botaoTrocar.text = "Cadastro"
                status = false
            } else {
                var cadastroFragment: CadastroFragment = CadastroFragment()
                fragmentTransaction.replace(R.id.container_fragments, cadastroFragment)
                fragmentTransaction.commit()
                botaoTrocar.text = "Login"
                status = true
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }
}
