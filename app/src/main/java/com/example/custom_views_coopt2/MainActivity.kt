import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.custom_views_coopt2.R
import com.example.custom_views_coopt2.SmileyFaceView


class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val smileyView = findViewById<SmileyFaceView>(R.id.smileyView)
    }


}
