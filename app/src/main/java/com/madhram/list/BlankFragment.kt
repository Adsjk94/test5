package com.madhram.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.madhram.test.R
import kotlinx.android.synthetic.main.blank_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import java.io.IOException
import kotlin.coroutines.CoroutineContext


class BlankFragment : Fragment() {

    private val url = "https://lifehack.studio/test_task/test.php"
    private val listCompanies = mutableListOf<Companies>()
    private lateinit var adapter: DataAdapter

    companion object {
        fun newInstance() = BlankFragment()
    }

    private lateinit var viewModel: BlankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.blank_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)

        adapter = DataAdapter()
        val llm = LinearLayoutManager(this.context)
        rw.layoutManager = llm
        rw.adapter = adapter

        GlobalScope.launch {
            getData()
        }
    }
    private fun getData() {
        try {
            val document = Jsoup.connect(url).get()
            val element = document.select("name")

            for (i in 0 until  element.size) {
                val title = element.select("name")
                    .eq(i)
                    .text()

                val linkImage = element.select("img")
                    .eq(i)
                    .attr("img")

                val linkDetails =
                    document.baseUri() +
                    element.select("id?")
                        .eq(i)
                        .select("id")

                listCompanies.add(Companies(title, linkImage, linkDetails))
            }
            GlobalScope.launch(Dispatchers.Main) {
                adapter.set(listCompanies)
            }
        } catch (e: IOException) {

        }
    }

}