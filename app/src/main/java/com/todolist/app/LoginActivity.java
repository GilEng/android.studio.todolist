package com.todolist.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import dao.UsuarioDAO;


public class LoginActivity extends ActionBarActivity {

    private EditText edtUsuario, edtSenha;
    private UsuarioDAO helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsuario = (EditText) findViewById(R.id.login_edtUsuario);
        edtSenha   = (EditText) findViewById(R.id.login_edtSenha);

        helper = new UsuarioDAO(this);
    }

    public void logar(View view){
        String usuario = edtUsuario.getText().toString();
        String senha   = edtSenha.getText().toString();

        boolean validacao = true;

        if(usuario == null || usuario.equals("")){
            validacao = false;
            edtUsuario.setError(getString(R.string.login_valUsuario));
        }

        if(senha == null || senha.equals("")){
            validacao = false;
            edtSenha.setError(getString(R.string.login_valSenha));
        }

        if(validacao){
            //logar
            if(helper.logar(usuario,senha)){
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
