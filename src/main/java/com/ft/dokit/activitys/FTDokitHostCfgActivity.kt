package com.ft.dokit.activitys

import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.ft.dokit.FTDokitCallbackManager
import com.ft.dokit.R

class FTDokitHostCfgActivity : AppCompatActivity() {
    companion object {
        const val DEFAULT_HOSTS_KEY = "default_hosts_key"
    }

    lateinit var hostList: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ft_dokit_host_cfg)

        hostList = intent.getStringArrayListExtra(DEFAULT_HOSTS_KEY) ?: listOf()

        findViewById<ListView>(R.id.cfg_list_view).apply {
            ArrayAdapter(
                this@FTDokitHostCfgActivity,
                android.R.layout.simple_list_item_1,
                hostList
            ).also {
                this.adapter = it
            }
            setOnItemClickListener { parent, view, position, id ->
                print(hostList[position])
                finish()
                FTDokitCallbackManager.hostChangeCallback?.onHostChanged(hostList[position])
            }
        }

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setTitle(R.string.dokit_plugin_host_cfg)
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> this.finish()
        }
        return super.onOptionsItemSelected(item)
    }
}