package com.nimgade.pk.vendingmachine.activities.user.interaction.view

import android.app.DialogFragment
import android.content.Context
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputEditText
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.nimgade.pk.vendingmachine.R
import com.nimgade.pk.vendingmachine.application.model.currency.Currency
import com.nimgade.pk.vendingmachine.application.model.currency.CurrencyChanger
import com.nimgade.pk.vendingmachine.application.model.currency.CurrencyUtils

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MakePaymentFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MakePaymentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MakePaymentFragment : DialogFragment() {

    val TAG = "MakePaymentFragment"

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null

    private var mListener: OnFragmentInteractionListener? = null

    private lateinit var rootLayout: CoordinatorLayout
    private lateinit var total_bill: TextView
    private lateinit var dollarsTextInputEditText: TextInputEditText
    private lateinit var centsTextInputEditText: TextInputEditText
    private lateinit var paymentTextView: TextView
    private lateinit var payButton: Button
    private lateinit var changeTextView: TextView

    private lateinit var currency: Currency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM_CURRENCY)
            currency = Gson().fromJson(mParam1, Currency::class.java)
            Log.d(TAG, "onCreate : $currency")
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_make_payment, container, false)
        initializeUI(view)
        return view
    }

    private fun initializeUI(view: View) {
        rootLayout = view.findViewById(R.id.MakePaymentFragment_root_layout_CoordinatorLayout)
        total_bill = view.findViewById(R.id.MakePaymentFragment_bill_TextView)
        dollarsTextInputEditText = view.findViewById(R.id.MakePaymentFragment_dollars_TextInputEditText)
        centsTextInputEditText = view.findViewById(R.id.MakePaymentFragment_cents_TextInputEditText)
        paymentTextView = view.findViewById(R.id.MakePaymentFragment_payment_TextView)
        changeTextView = view.findViewById(R.id.MakePaymentFragment_change_TextView)
        payButton = view.findViewById(R.id.MakePaymentFragment_pay_Button)
        payButton.setOnClickListener {
            Log.d(TAG, ": payButton")
            checkPayment()
        }

        total_bill.text = currency.toString()
    }

    private fun checkPayment() {
        val dollars = dollarsTextInputEditText.text.toString()
        val cents = centsTextInputEditText.text.toString()

        if (!dollars.isNullOrBlank() && !cents.isNullOrEmpty()) {
            val dollarsInt = Integer.parseInt(dollars)
            val centsInt = Integer.parseInt(cents)
            if (centsInt < 100) {
                val payment = Currency(dollarsInt, centsInt)
                Log.d(TAG, "currency: $currency")
                Log.d(TAG, "payment: $payment")
                Log.d(TAG, ": ${payment.compareTo(currency)}")
                if ((payment.compareTo(currency)) >= 0) {
                    paymentTextView.text = payment.toString()
                    makePaymentAndChange(payment, currency)
                } else {
                    paymentTextView.text = payment.toString()
                    showMessageToUser("Not enough to pay bill")
                }
            } else {
                showMessageToUser("Cents should be < 100")
            }
        } else {
            Log.d(TAG, ": ")
            showMessageToUser("Dollars or Cents missing")
        }
    }

    private fun makePaymentAndChange(payment: Currency, currency: Currency) {
        val reduced = payment.reduceBy(currency)
        Log.d(TAG, "makePaymentAndChange: $reduced")

        val change: CurrencyChanger = CurrencyUtils(reduced)
        val currencyChanger = change.change
        changeTextView.visibility = View.VISIBLE
        changeTextView.text = "Change: $currencyChanger"
        Log.d(TAG, ": $currencyChanger")

        if (mListener != null) {
            (mListener as OnFragmentInteractionListener).onFragmentInteraction()
        }
    }

    private fun showMessageToUser(message: String?) {
        Snackbar.make(rootLayout, message + "", Snackbar.LENGTH_SHORT).show()
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(userPayment: Currency) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction()
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM_CURRENCY = "param_currency"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param currency Parameter 1.
         * @return A new instance of fragment MakePaymentFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(currency: String): MakePaymentFragment {
            val fragment = MakePaymentFragment()
            val args = Bundle()
            args.putString(ARG_PARAM_CURRENCY, currency)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
