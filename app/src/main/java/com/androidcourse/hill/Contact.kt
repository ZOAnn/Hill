package com.androidcourse.hill

import android.content.Context
import org.json.JSONException
import org.json.JSONObject


class Contact(val icon: String,val name: String, val info: String) {
  companion object {

    fun getRecipesFromFile(filename: String, context: Context): ArrayList<Contact> {
      val recipeList = ArrayList<Contact>()

      try {
        // Load data
        val jsonString = loadJsonFromAsset("contacts.json", context)
        val json = JSONObject(jsonString)
        val recipes = json.getJSONArray("contacts")

        // Get Recipe objects from data
        (0 until recipes.length()).mapTo(recipeList) {
          Contact(
                  recipes.getJSONObject(it).getString("icon"),
                  recipes.getJSONObject(it).getString("name"),
              recipes.getJSONObject(it).getString("info")
          )
        }
      } catch (e: JSONException) {
        e.printStackTrace()
      }
      return recipeList
    }
    private fun loadJsonFromAsset(filename: String, context: Context): String? {
      var json: String? = null
      try {
        val inputStream = context.assets.open(filename)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        json = String(buffer, Charsets.UTF_8)
      } catch (ex: java.io.IOException) {
        ex.printStackTrace()
        return null
      }
      return json
    }
  }
}