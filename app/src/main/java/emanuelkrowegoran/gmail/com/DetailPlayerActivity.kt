package emanuelkrowegoran.gmail.com

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class DetailPlayerActivity : AppCompatActivity() {
    internal lateinit var tvNo: TextView
    internal lateinit var tvNama: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_player)

        tvNo = findViewById(R.id.tvNo)
        tvNama = findViewById(R.id.tvNama)


        val playerItem = intent.getParcelableExtra<PlayerItem>(EXTRA_PLAYER)

        val no = playerItem.no
        val name = playerItem.name

        tvNo.text = no
        tvNama.text = name


    }

    companion object {

        var EXTRA_PLAYER = "extra_player"
    }
}
