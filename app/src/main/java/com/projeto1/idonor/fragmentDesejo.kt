package com.projeto1.idonor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class fragmentDesejo : Fragment() {


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
        val view = inflater.inflate(R.layout.fragment_desejo, container, false)

        view.findViewById<Button>(R.id.botaoinfowishlist).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_fragmentDesejo_to_fragmentInfo)
        }
        view.findViewById<Button>(R.id.botaocontatowishlist).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_fragmentDesejo_to_fragmentContato)
        }
        view.findViewById<Button>(R.id.botaoavaliacaowishlist).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_fragmentDesejo_to_fragmentAvaliacao)
        }


        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragmentDesejo().apply {
                arguments = Bundle().apply {

                }
            }
    }
}