package com.example.kursovarabota

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import mymanager
import places

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val page1 = frag2()
        val page2 = frag3()
        val page3 = frag4()
        Smqna_Stranici(page1)
        val lenta = findViewById<BottomNavigationView>(R.id.bottom_menu)
        lenta.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.places -> Smqna_Stranici(page1)
                R.id.info -> Smqna_Stranici(page2)
                R.id.settings -> Smqna_Stranici(page3)
            }
            true
        }
    }

    private fun Smqna_Stranici(tekushta: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.ramka, tekushta)
            commit()
        }
    }

    fun btn_spodeli(view: View)
    {
        val btn = findViewById<Button>(R.id.button)
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Искам да споделя това приложение!")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    fun btn_razberi(view: View)
    {
        val btn = findViewById<Button>(R.id.button3)
        val dlg= AlertDialog.Builder(this)
        dlg.setTitle("Варна - морската столица")
        dlg.setMessage("    Варна (Varna) е третият по големина град в България - Морската столица. Разположен е в "+
        "Североизточна България. Варна е туристически център, отправна точка за много курорти по Северното Черноморие. "+
        "Варна е център на много културни прояви като фестивалът „Варненско лято“, кинофестивалът „Любовта е лудост“.\n"+
        "   Историята на града е хилядолетна. Варна е носила името Одесос и според ранни писмени сведения градът е основан " +
        "от изселници от малоазийския град Милет през VI в. пр.н.е. Това е периодът на Великата гръцка колонизация.\n" +
        "   Интересни забележителности в града са: Морската градина, Делфинариума, Астрономическа обсерватория и планетариум " +
        "Николай Коперник, Варненският некропол — най-старото златно съкровище в света, Варненски археологически музей, " +
        "Военноморски музей, Музей за нова история, Етнографски музей, Музей на Възраждането.\n" +
        "   В околностите на Варна се намират: Аладжа манастир — скален манастир, Побитите камъни, Резерват Камчия.")

        dlg.setPositiveButton("Задай син цвят на бутона") { dialog, which ->
            btn.setBackgroundColor(Color.BLUE)
        }
        dlg.setNegativeButton("Задай червен цвят на бутона") { dialog, which ->
            btn.setBackgroundColor(Color.RED)
        }
        dlg.show()
    }
}




