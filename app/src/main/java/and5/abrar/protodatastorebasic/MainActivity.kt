package and5.abrar.protodatastorebasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var  mainviewmodel : UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainviewmodel = ViewModelProvider(this).get(UserViewModel::class.java)
        mainviewmodel.data.observe(this,{
            textView.text = it.name
        })
        save_btn.setOnClickListener {
            mainviewmodel.update(name_et.text.toString())
        }
        clear_btn.setOnClickListener {
            mainviewmodel.delete()
        }
    }
}