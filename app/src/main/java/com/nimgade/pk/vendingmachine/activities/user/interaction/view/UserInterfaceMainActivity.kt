package com.nimgade.pk.vendingmachine.activities.user.interaction.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.nimgade.pk.vendingmachine.R
import com.nimgade.pk.vendingmachine.activities.user.interaction.presenter.IUserInterfacePresenter
import com.nimgade.pk.vendingmachine.activities.vendor.backend.view.VendorBackdoorActivity
import com.nimgade.pk.vendingmachine.application.StartUp
import com.nimgade.pk.vendingmachine.application.model.currency.Currency
import kotlinx.android.synthetic.main.activity_vending_machine_main.*
import javax.inject.Inject


class UserInterfaceMainActivity : AppCompatActivity(), IUserInterfaceView {

    val TAG = "UserInterfaceMainActivity"

    @Inject
    lateinit var presenter: IUserInterfacePresenter

    private lateinit var rootLayout: CoordinatorLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var quantityTextView: TextView
    private lateinit var billTextView: TextView
    private lateinit var makePayment: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vending_machine_main)
        setSupportActionBar(toolbar)
        initializeUI()
    }

    private fun initializeUI() {
        rootLayout = findViewById(R.id.UserInterfaceMainActivity_root_layout_CoordinatorLayout)
        recyclerView = findViewById(R.id.UserInterfaceMainActivity_Product_List_RecyclerView)
        quantityTextView = findViewById(R.id.UserInterfaceMainActivity_quantity_textView)
        billTextView = findViewById(R.id.UserInterfaceMainActivity_total_textView)
        makePayment = findViewById(R.id.UserInterfaceMainActivity_make_payment_button)
        makePayment.setOnClickListener {
            presenter.makePayment()
        }

        (application as StartUp).userInterfaceComponent.inject(this)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val productListAdapter = ProductListAdapter(this, 8, presenter)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = productListAdapter
        productListAdapter.notifyDataSetChanged()
    }

    override fun showFragment(currency: Currency?) {
        val makePayment = MakePaymentFragment.newInstance((Gson().toJson(currency)))
        makePayment.show(fragmentManager, "MakePaymentFragment")
    }

    override fun showMessageToUser(message: String?) {
        Snackbar.make(rootLayout, "" + message, Snackbar.LENGTH_SHORT).show()
    }

    override fun totalBillForQuantity(bill: String?) {
        billTextView.text = bill
    }

    override fun quantityOfProduct(quantity: String?) {
        quantityTextView.text = quantity
    }


    override fun onResume() {
        super.onResume()
        presenter.setView(this)
    }

    override fun onFragmentInteraction() {
        presenter.purchaseWasMade()
        quantityTextView.text = "0"
        billTextView.text = "0"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_vending_machine_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.back_door -> {
                startActivity(Intent(this, VendorBackdoorActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
