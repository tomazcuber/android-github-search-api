package br.com.tomazcuber.githubapi.util

enum class Sort(val property: String, val direction: String) {
    CREATED_ASC("created", "asc"),
    CREATED_DESC("created", "desc"),
    UPDATED_ASC("updated", "asc"),
    UPDATED_DESC("updated", "desc"),
    PUSHED_ASC("pushed", "asc"),
    PUSHED_DESC("pushed", "desc"),
    FULL_NAME_ASC("full_name", "asc"),
    FULL_NAME_DESC("full_name", "desc");
}