package com.troxumenko.glider.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.troxumenko.glider.extentions.inflateVB

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB
        private set

    protected abstract fun creatingBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = creatingBinding()
        setContentView(binding.root)
    }

    protected inline fun <reified T : ViewBinding> inflate(): T {
        return layoutInflater.inflateVB(null, null)
    }
}