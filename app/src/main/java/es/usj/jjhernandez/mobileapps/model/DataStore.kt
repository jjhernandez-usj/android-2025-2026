package es.usj.jjhernandez.mobileapps.model


object DataStore {
    val actors = mutableListOf<Actor>()

    fun addAll(actors: List<Actor>) {
        this.actors.addAll(actors)
    }
}