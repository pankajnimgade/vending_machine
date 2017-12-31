package com.nimgade.pk.vendingmachine.activities.vendor.backend.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.nimgade.pk.vendingmachine.R
import com.nimgade.pk.vendingmachine.activities.vendor.backend.presenter.VendorBackdoorPresenter
import com.nimgade.pk.vendingmachine.application.StartUp
import kotlinx.android.synthetic.main.activity_vendor_backdoor.*
import javax.inject.Inject

class VendorBackdoorActivity : AppCompatActivity(), IVendorBackdoorActivityView {

    val TAG = "VendorBackdoorActivity"

    @Inject
    lateinit var presenter: VendorBackdoorPresenter

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_backdoor)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        (application as StartUp).vendorBackdoorComponent.inject(this)

        initializeUI()
    }

    private fun initializeUI() {
        recyclerView = findViewById(R.id.VendorBackdoorActivity_product_list_RecyclerView)

        val productTypeListAdapter = ProductTypeAdapter(8, this, presenter)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = productTypeListAdapter
        productTypeListAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
    }

    override fun addProduct(productType: Int) {
        // not in use
    }

}
