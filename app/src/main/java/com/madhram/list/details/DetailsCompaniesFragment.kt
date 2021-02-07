package com.madhram.list.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.madhram.test.R
import kotlinx.android.synthetic.main.details_companies_fragment.*

class DetailsCompaniesFragment : Fragment() {

    companion object {
        fun newInstance() = DetailsCompaniesFragment()
    }

    private lateinit var viewModel: DetailsCompaniesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_companies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsCompaniesViewModel::class.java)
        // TODO: Use the ViewModel

        link.text = arguments?.getString("link")
    }

}