package com.example.server

import Constants.Companion.API_KEY
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.server.API.ApiClient
import com.example.server.API.ApiService
import com.example.server.MVVM.MainViewModel
import com.example.server.adapters.ServerListCustomAdapter
import com.example.server.model.Article
import com.example.server.model.ResponseResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class ItemFragment : Fragment() {
    private var serverList = ArrayList<Article>()
    private lateinit var serverListCustomAdapter: ServerListCustomAdapter
    private lateinit var recyclerView: RecyclerView
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        viewModel.getArticles(API_KEY)
        viewModel.articlesLiveData.observe(viewLifecycleOwner) {
            serverListCustomAdapter.setList(it as ArrayList<Article>?)
        }

    }

    private fun initRecyclerView() {
        recyclerView = requireView().findViewById(R.id.reyclerViewServer)
        serverListCustomAdapter = ServerListCustomAdapter(serverList)
        recyclerView.adapter = serverListCustomAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


}
