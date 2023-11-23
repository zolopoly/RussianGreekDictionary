package ru.example.russian_greekdictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button button;
    TextView output;
    SwitchCompat languageSwitcher;
    TextView headerLanguage;
    HashMap<String, String> language = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        button = findViewById(R.id.button);
        output = findViewById(R.id.output);
        languageSwitcher = findViewById(R.id.language_switcher);
        headerLanguage = findViewById(R.id.header_language);

        //Слушатель переключателя словарей
        languageSwitcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    createDictionaryRuGr();
                    headerLanguage.setText(R.string.switch_ru_gr_mode);
                } else {
                    createDictionaryGrRu();
                    headerLanguage.setText(R.string.switch_gr_ru_mode);
                }
            }
        });

        languageSwitcher.setChecked(true);

        //слушатель нажатия на кнопку
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = input.getText().toString().trim().toLowerCase(Locale.ROOT);
                String outputText = language.get(inputText);
                if (outputText != null) {
                    output.setText(outputText.toLowerCase(Locale.ROOT));
                } else {
                    output.setText(R.string.hint_has_no_translation);
                }
            }
        });
    }

    void createDictionaryRuGr() {
        language.clear();
        language.put("немного", "Λίγο |Lígo| [лиго]");
        language.put("звезда", "Αστέρι |Astéri| [астэри]");
        language.put("очень", "Πολύ |Polý| [поли]");
        language.put("деньги", "Χρήματα |Chrímata| [кримата]");
        language.put("машина", "Αυτοκίνητο |Aftokínito| [афтокинито]");
        language.put("сестра", "Αδελφή |Adelfí| [адельфи]");
        language.put("брат", "Αδελφός |Adelfós| [адельфос]");
        language.put("мать", "Μητέρα |Mitéra| [митэра]");
        language.put("отец", "Πατέρας |Patéras| [патэрас]");
        language.put("имя", "Ονομα |Onoma| [Онома]");
        language.put("друг", "Φίλε |Fíle| [филэ]");
        language.put("да", "Ναί |Naí| [нэ]");
        language.put("нет", "Οχι |Ochi| [охи]");
        language.put("я", "Εγώ |Egó| [эго]");
        language.put("мы", "εμείς |Emeís| [эмис]");
        language.put("все", "όλα |óla| [ола]");
    }

    void createDictionaryGrRu() {
        language.clear();
        language.put("lígo", "немного");
        language.put("astéri", "звезда");
        language.put("polý", "очень");
        language.put("chrímata", "деньги");
        language.put("aftokínito", "машина");
        language.put("adelfí", "сестра");
        language.put("adelfós", "брат");
        language.put("mitéra", "мать");
        language.put("patéras", "отец");
        language.put("onoma", "имя");
        language.put("fíle", "друг");
        language.put("naí", "да");
        language.put("ochi", "нет");
        language.put("egó", "я");
        language.put("emeís", "мы");
        language.put("óla", "все");
    }
}