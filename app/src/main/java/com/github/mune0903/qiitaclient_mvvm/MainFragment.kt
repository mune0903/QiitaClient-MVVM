package com.github.mune0903.qiitaclient_mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.github.mune0903.qiitaclient_mvvm.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    // viewにアクセスするやつ
    private lateinit var binding: FragmentMainBinding

    // ViewModel
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // databindingの設定
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        binding = FragmentMainBinding.bind(view)
        return binding.root
    }

    // データのfetchやUI操作に関わる処理はonViewCreatedで実行する
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // LifecycleObserverの設定
        lifecycle.addObserver(viewModel)

    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
