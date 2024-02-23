package com.projeto1.idonor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class fragmentAvaliacao : Fragment() {


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
        val view = inflater.inflate(R.layout.fragment_avaliacao, container, false)


        view.findViewById<Button>(R.id.botaoinfoavaliacao).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_fragmentAvaliacao_to_fragmentInfo)
        }
        view.findViewById<Button>(R.id.botaowishlistavaliacao).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_fragmentAvaliacao_to_fragmentDesejo)
        }
        view.findViewById<Button>(R.id.botaocontatoavaliacao).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_fragmentAvaliacao_to_fragmentContato)
        }


        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragmentAvaliacao().apply {
                arguments = Bundle().apply {

                }
            }
    }
}