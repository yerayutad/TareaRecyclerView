package com.yeraydeza.tarearecyclerview_yeray_de

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.yeraydeza.tarearecyclerview_yeray_de.adapter.UserAdapter
import com.yeraydeza.tarearecyclerview_yeray_de.data.FakeData
import com.yeraydeza.tarearecyclerview_yeray_de.data.RepositoriesJson
import com.yeraydeza.tarearecyclerview_yeray_de.databinding.ActivityMainBinding
import com.yeraydeza.tarearecyclerview_yeray_de.model.toRepositories

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gson = GsonBuilder().create()
        val result = gson.fromJson(FakeData.repositoriesJson, Array<RepositoriesJson>::class.java)

        (application as App).users.addAll(result.map { it.toRepositories() })

        val repositories = (application as App).users
        adapter = UserAdapter(repositories) { repository ->
            Log.d("MainActivity", "usuario pulsado: ${repository.id}")
            val intent = Intent(this, DetailRepository::class.java)
            intent.putExtra("userId", repository.id)
            startActivity(intent)
        }
        binding.rvRepositories.adapter = adapter
        binding.rvRepositories.layoutManager = LinearLayoutManager(this)

        binding.rvRepositories.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

    }
}
