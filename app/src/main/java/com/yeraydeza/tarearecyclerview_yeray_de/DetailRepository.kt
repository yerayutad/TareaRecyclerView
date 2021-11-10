package com.yeraydeza.tarearecyclerview_yeray_de

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.yeraydeza.tarearecyclerview_yeray_de.databinding.DetailItemBinding

class DetailRepository : AppCompatActivity() {
    private lateinit var binding:DetailItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var aux = ""

        val repositoryId = intent.getIntExtra("userId", -1)
        val repository = (application as App).users.first { it.id == repositoryId }

        if (repository.topics.isEmpty()){
            aux = "No tags"
        }else {
            for (i in repository.topics.indices) {
                aux += " #${repository.topics.get(i)}"
            }
        }

        binding.tvDescrp.text = "${repository.description}"
        binding.tvLenguage.text = "${repository.language}"
        binding.tvNameDetail.text = "${repository.name}"
        binding.tvLicense.text = "${repository.license}"
        binding.tvTags.text = aux
        Picasso.get()
            .load(repository.picture)
            .placeholder(R.mipmap.ic_launcher)
            .into(binding.imgIdDetail)

    }
}