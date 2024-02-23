package com.projeto1.idonor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class fragmentInfo : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_info, container, false)
        view.findViewById<Button>(R.id.botaowishlistinfo).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_fragmentInfo_to_fragmentDesejo)
        }
        view.findViewById<Button>(R.id.botaocontatoinfo).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_fragmentInfo_to_fragmentContato)
        }
        view.findViewById<Button>(R.id.botaoavaliacaoinfo).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_fragmentInfo_to_fragmentAvaliacao)
        }
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragmentInfo().apply {
                arguments = Bundle().apply {

                }
            }
    }
}