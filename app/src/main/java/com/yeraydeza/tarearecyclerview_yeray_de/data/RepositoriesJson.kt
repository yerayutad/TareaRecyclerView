package com.yeraydeza.tarearecyclerview_yeray_de.data

data class RepositoriesJson(
    var id: Int,
    var name: String,
    var owner: Owner,
    var description: String,
    var language: String?,
    var license: License?,
    var topics: Array<String>
)

data class Owner(
    var avatar_url: String
)

data class License(
    var name: String,
)
