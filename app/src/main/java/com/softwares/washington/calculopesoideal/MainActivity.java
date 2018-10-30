package com.softwares.washington.calculopesoideal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgSexo;
    private ImageView imgSexo;
    private Button btnCalcular;
    private RadioButton rbFeminino, rbMasculino;
    private int sexoEscolhido;
    private EditText edtAltura;
    private float pesoIdeal, altura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgSexo= findViewById(R.id.rgSexoId);
        imgSexo= findViewById(R.id.imgSexoId);
        btnCalcular= findViewById(R.id.btnCalcularId);
        rbFeminino= findViewById(R.id.rbFemininoId);
        rbMasculino=findViewById(R.id.rbMasculinoId);
        edtAltura= findViewById(R.id.edtAlturaId);

        rbMasculino.setChecked(true);
        sexoEscolhido= 1;

        rgSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i== 2131165283){
                    imgSexo.setImageResource(R.drawable.male_user);
                    sexoEscolhido=1;
                }else{
                    imgSexo.setImageResource(R.drawable.female_user);
                    sexoEscolhido=2;
                }
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(sexoEscolhido==1){
                    sexoEscolhido=4;
                }else {
                    sexoEscolhido=2;
                }

                if(!edtAltura.getText().toString().isEmpty()){

                    altura= Float.parseFloat(edtAltura.getText().toString());
                    pesoIdeal= (altura-100)- ((altura-150)/sexoEscolhido);

                    Toast.makeText(getApplicationContext(), "O peso ideal é: "+String.valueOf(pesoIdeal), Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getApplicationContext(), "Campo de preenchimento obrigatório!", Toast.LENGTH_LONG).show();
                    edtAltura.requestFocus();
                }
            }
        });
    }
}
