package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }

    private val database by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database").build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val databaseMenuItems by database.menuItemDao().getAll().observeAsState(emptyList())
            var orderMenuItems by remember {
                mutableStateOf(false)
            }
            LittleLemonTheme {
                val navController = rememberNavController()
                MyNavigation(navController = navController)
            }
        }

    }


    private fun fetchMenu() {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val menuData: MenuNetwork = httpClient.get("URL_TO_YOUR_JSON_ENDPOINT")
                val menuItems: List<MenuItemNetwork> = menuData.menu

                // Now you have the list of menu items, you can process them as needed
                for (menuItem in menuItems) {
                    // Handle each menu item (e.g., display in a RecyclerView)
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

}

@Composable
fun MyNavigation(navController: NavHostController) {
    Navigation(navController)
}


