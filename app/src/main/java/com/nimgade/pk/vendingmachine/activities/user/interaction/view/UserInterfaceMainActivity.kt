package com.nimgade.pk.vendingmachine.activities.user.interaction.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.nimgade.pk.vendingmachine.R
import com.nimgade.pk.vendingmachine.activities.user.interaction.presenter.IUserInterfacePresenter
import com.nimgade.pk.vendingmachine.application.StartUp
import kotlinx.android.synthetic.main.activity_vending_machine_main.*
import javax.inject.Inject


class UserInterfaceMainActivity : AppCompatActivity() {

    val TAG = "UserInterfaceMainActivity"

    @Inject
    lateinit var presenter: IUserInterfacePresenter

    private lateinit var recyclerView: RecyclerView
    private lateinit var makePayment: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vending_machine_main)
        setSupportActionBar(toolbar)
        initializeUI()
    }

    private fun initializeUI() {
        recyclerView = findViewById(R.id.UserInterfaceMainActivity_Product_List_RecyclerView)
        makePayment = findViewById(R.id.UserInterfaceMainActivity_make_payment_button)

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


    override fun onResume() {
        super.onResume()
        presenter.setView(this)
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
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
