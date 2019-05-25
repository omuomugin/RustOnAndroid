package omuomugin.io.rustclient

import android.content.Context

object RustClient {

    fun initialize() {
        System.loadLibrary("rust_logic")
    }

    fun sayHello(to: String): String {
        return greeting(to)
    }

    fun additionOnRust(context: Context, left: Int, right: Int): Int {
        val result = addition(left, right)

        // 副作用をライブラリで吸収する
        saveResult(context, result)

        return getResult(context)
    }

    private fun saveResult(context: Context, result: Int) {
        val data = context.getSharedPreferences("RustClientData", Context.MODE_PRIVATE)

        val oldResult = data.getInt("result", 0)

        val editor = data.edit()
        editor.putInt("result", oldResult + result)
        editor.apply()
    }

    private fun getResult(context: Context): Int {
        val data = context.getSharedPreferences("RustClientData", Context.MODE_PRIVATE)
        return data.getInt("result", 0)
    }
}