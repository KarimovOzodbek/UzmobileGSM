package pl.ozodbek.uzmobilegsm.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import pl.ozodbek.uzmobilegsm.MainActivity
import pl.ozodbek.uzmobilegsm.R
import pl.ozodbek.uzmobilegsm.adapter.TabLayoutAdapter
import pl.ozodbek.uzmobilegsm.databinding.FragmentBalansBinding
import pl.ozodbek.uzmobilegsm.databinding.FragmentInternetPaketBinding
import pl.ozodbek.uzmobilegsm.databinding.FragmentInternetSpeedBinding

class InternetPaketFragment : Fragment() {

    private var _binding: FragmentInternetPaketBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInternetPaketBinding.inflate(inflater, container, false)

        binding.upButton.setOnClickListener {
            findNavController().navigate(R.id.action_internetPaketFragment_to_homeFragment)
            (requireActivity() as MainActivity).binding.bottomnav.selectedItemId = R.id.action_add
        }

        val fragments = ArrayList<Fragment>()
        fragments.add(XizmatlarFragment())
        fragments.add(XizmatlarFragment())
        fragments.add(XizmatlarFragment())
        fragments.add(XizmatlarFragment())

        val titles = ArrayList<String>()
        titles.add("Kunlik")
        titles.add("Haftalik")
        titles.add("Oylik")
        titles.add("Yillik")



        val pagerAdapter = TabLayoutAdapter(
            fragments,
            requireActivity()
        )
        binding.viewPager2.isUserInputEnabled = false
        binding.viewPager2.apply {
            adapter = pagerAdapter
        }

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = titles[position]
        }.attach()

        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
