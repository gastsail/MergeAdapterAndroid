package com.mergeadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import com.mergeadapter.adapters.FooterAdapter
import com.mergeadapter.adapters.HeaderAdapter
import com.mergeadapter.adapters.MainAdapter
import com.mergeadapter.datasource.DataSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    recyclerView.layoutManager = LinearLayoutManager(this)
    val headerAdapter = HeaderAdapter(this,"HEADER PRUEBA")
    val mainAdapter = MainAdapter(this,DataSource.generateUserList)
    val footerAdapter = FooterAdapter(this,"FOOTER PRUEBA")
    val mergeAdapter = MergeAdapter(headerAdapter,mainAdapter,footerAdapter)
    recyclerView.adapter = mergeAdapter

  }
}
