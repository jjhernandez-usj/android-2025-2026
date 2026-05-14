package es.usj.jjhernandez.mobileapps.model

data class Actor(val id: String, val name: String) {

    override fun toString(): String {
        return "$id,$name"
    }
}