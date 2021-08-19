package userstore

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit

// why do we add (val context: Context)
class UserStore(private val context: Context) {
    fun saveJwt(jwt: String) {
        sharedPrefs().edit(commit = true) {
            putString("jwt", jwt)
        }
    }

    fun getJwt() = sharedPrefs().getString("jwt", null)
    fun deleteJwt() = sharedPrefs().edit(commit = true) {
        remove("jwt")
    }

    private fun sharedPrefs() = context.getSharedPreferences("userStore", MODE_PRIVATE)
}