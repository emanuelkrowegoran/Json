package emanuelkrowegoran.gmail.com

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    internal lateinit var listView: ListView
    private var playerItemList: MutableList<PlayerItem>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        playerItemList = ArrayList()



        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, l ->
            val playerItem = playerItemList!![position]

            val i = Intent(applicationContext, DetailPlayerActivity::class.java)
            i.putExtra(DetailPlayerActivity.EXTRA_PLAYER, playerItem)
            startActivity(i)
        }
        loadPlayer()
    }

    private fun loadPlayer() {
        val stringRequest = StringRequest(Request.Method.GET, JSON_URL,
            Response.Listener { response ->
                try {
                    val obj = JSONObject(response)
                    val playerArray = obj.getJSONArray("result")

                    for (i in 0 until playerArray.length()) {

                        val playerObject = playerArray.getJSONObject(i)


                        val playerItem = PlayerItem(playerObject.getString("no"),
                            playerObject.getString("name"),
                            playerObject.getString("Position"),
                            playerObject.getString("birth_date"),
                            playerObject.getString("Poster"))

                        playerItemList!!.add(playerItem)
                    }

                    val adapter = ListViewAdapter(this!!.playerItemList!!, applicationContext)

                    listView.adapter = adapter

                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error -> Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show() })

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }

    companion object {

        private val JSON_URL = "https://emanuelkrowegoran.github.io/FootBallPlayer/AllPlayer.json"
    }
}