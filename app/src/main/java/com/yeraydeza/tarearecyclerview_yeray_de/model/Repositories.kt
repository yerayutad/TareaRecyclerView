package com.yeraydeza.tarearecyclerview_yeray_de.model

import com.yeraydeza.tarearecyclerview_yeray_de.data.RepositoriesJson


class Repositories(val id: Int, val name: String, val description: String, val picture: String, val language: String, val license: String, val topics: Array<String>)

fun RepositoriesJson.toRepositories():Repositories = Repositories(this.id,this.name,this.description, this.owner.avatar_url, this.language ?: "No language", this.license?.name ?: "No license", this.topics)

fun List<RepositoriesJson>.toRepositories(): List<Repositories> =this.map { RepositoriesJson -> RepositoriesJson.toRepositories() }