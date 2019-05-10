package emanuelkrowegoran.gmail.com

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide


class ListViewAdapter(private val playerItemList: List<PlayerItem>,
                      internal val context: Context) : ArrayAdapter<PlayerItem>(context, R.layout.list_item, playerItemList) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)

        val listViewItem = inflater.inflate(R.layout.list_item, null, true)

        val textViewNo = listViewItem.findViewById<TextView>(R.id.textViewNo)
        val textViewName = listViewItem.findViewById<TextView>(R.id.textViewName)
        val textViewPosition = listViewItem.findViewById<TextView>(R.id.textViewPosition)
        val textViewBirth_date = listViewItem.findViewById<TextView>(R.id.textViewBirthDate)
        val imgVIew = listViewItem.findViewById<ImageView>(R.id.Poster)


        val playerItem = playerItemList[position]

        textViewNo.text = playerItem.no
        textViewName.text = playerItem.name
        textViewBirth_date.text = playerItem.birth_date
        textViewPosition.text = playerItem.position

        Glide.with(context).load(playerItem.poster).into(imgVIew)

        return listViewItem
    }
}