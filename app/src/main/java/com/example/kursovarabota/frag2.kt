package com.example.kursovarabota

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import mymanager
import places

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [frag2.newInstance] factory method to
 * create an instance of this fragment.
 */
class frag2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val book: ArrayList<places> = ArrayList()

        val page1 = frag_place_1()
        val page2 = frag_place_2()
        val page3 = frag_place_3()
        Smqna_Stranici(page1)

        val lenta = view.findViewById<BottomNavigationView>(R.id.menu_places)

        lenta.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.razhodki -> Smqna_Stranici(page1)
                R.id.plaj -> Smqna_Stranici(page2)
                R.id.snimki -> Smqna_Stranici(page3)
            }
            true
        }
    }

    private fun Smqna_Stranici(tekushta: Fragment) {
        childFragmentManager.beginTransaction().apply {
            replace(R.id.ramka, tekushta)
            commit()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment frag2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            frag2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}