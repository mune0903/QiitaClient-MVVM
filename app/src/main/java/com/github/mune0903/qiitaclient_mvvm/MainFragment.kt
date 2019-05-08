package com.github.mune0903.qiitaclient_mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mune0903.qiitaclient_mvvm.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    // viewにアクセスするやつ
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // databindingの設定
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        binding = FragmentMainBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
