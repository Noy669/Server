package com.example.server.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.server.R
import com.example.server.R.drawable.custom_divider
import com.example.server.databinding.FragmentItemListBinding
import com.example.server.mvvm.MainViewModel
import com.example.server.presentation.adapters.ServerListCustomAdapter
import com.example.server.presentation.model.Article
import org.koin.androidx.viewmodel.ext.android.viewModel


class ItemFragment : Fragment() {
    private var serverList = ArrayList<Article>()
    private lateinit var binding: FragmentItemListBinding
    private lateinit var serverListCustomAdapter: ServerListCustomAdapter
    private lateinit var recyclerView: RecyclerView
    private val viewModel: MainViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        binding = FragmentItemListBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
        initRecyclerView()
        observeLiveData()
        setRecyclerViewDivider()

    }

    private fun initRecyclerView() {
        recyclerView = binding.reyclerViewServer
        serverListCustomAdapter = ServerListCustomAdapter(serverList)
        recyclerView.adapter = serverListCustomAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setRecyclerViewDivider() {
        val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        divider.setDrawable(
            AppCompatResources.getDrawable(
                requireContext(),
                custom_divider
            )!!
        )
        recyclerView.addItemDecoration(divider)
    }

    private fun setData() {
        viewModel.getArticles("us", "business")
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeLiveData() {
        viewModel.articlesLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                serverListCustomAdapter.setList(it)
            }
        }
        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                serverListCustomAdapter.apply {
                    setList(ArrayList())
                    this.notifyDataSetChanged()
                }
            }
        }
    }


}

