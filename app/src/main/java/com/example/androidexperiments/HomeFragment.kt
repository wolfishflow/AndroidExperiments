package com.example.androidexperiments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.androidexperiments.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView.load(COVER_IMAGE) {
            crossfade(300)
            allowHardware(false)
            placeholder(ColorDrawable(Color.parseColor(COVER_IMAGE_COLOR)))
        }

        binding.cardView.setOnClickListener {
            val directions = HomeFragmentDirections.actionHomeFragmentToDetailFragment()
            val extras = FragmentNavigatorExtras (
                binding.imageView to "imageView"
            )


            findNavController().navigate(
                directions,
                FragmentNavigator.Extras.Builder()
                    .addSharedElement(binding.imageView, "imageView")
                    .build()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val COVER_IMAGE = "https://s4.anilist.co/file/anilistcdn/media/anime/cover/large/bx113415-979nF8TZP2xC.jpg"
        const val COVER_IMAGE_COLOR = "#5d93e4"
    }

}