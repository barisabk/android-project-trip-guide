import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kursovarabota.R


class mymanager(val myplaces:ArrayList<places>): RecyclerView.Adapter<mymanager.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_red, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val elem:places = myplaces[position]
        holder.bind(elem)
    }

    override fun getItemCount(): Int {
        return myplaces.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(elem: places) {
            itemView.findViewById<TextView>(R.id.textView).text = elem.title
            itemView.findViewById<TextView>(R.id.textView2).text = elem.desc
            itemView.findViewById<TextView>(R.id.textView7).text = "Рейтинг: "+elem.reiting.toString()

            when (elem.place) {
                1 -> itemView.findViewById<ImageView>(R.id.imageView3).setImageResource(R.drawable.azalia)
                2 -> itemView.findViewById<ImageView>(R.id.imageView3).setImageResource(R.drawable.drujba)
                3 -> itemView.findViewById<ImageView>(R.id.imageView3).setImageResource(R.drawable.kolelo_morska_gara)
                4 -> itemView.findViewById<ImageView>(R.id.imageView3).setImageResource(R.drawable.morska_gradina)
                5 -> itemView.findViewById<ImageView>(R.id.imageView3).setImageResource(R.drawable.gledka_galata)
                6 -> itemView.findViewById<ImageView>(R.id.imageView3).setImageResource(R.drawable.fara)
            }
        }
    }
}