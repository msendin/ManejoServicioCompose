package com.example.manejoserviciocompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.manejoserviciocompose.ui.theme.ManejoServicioComposeTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ManejoServicioComposeTheme {
                Surface {
                    Replaying(
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }


@Composable
fun Replaying(modifier: Modifier = Modifier) {
    Column (modifier = modifier.fillMaxSize()){
        val context = LocalContext.current
        val b = Bundle()
        val servInt = Intent(
            context,
            ElServicio::class.java
        )
        Text(
            modifier = Modifier.padding(vertical = 54.dp).align(Alignment.CenterHorizontally),
            text = stringResource(R.string.goal)
        )
        Row (
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ){
            ElevatedButton(
                modifier = Modifier.padding(vertical = 34.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(5.dp),
                onClick = {
                    b.putString(MYDEFAULTSTRING_ID, R.string.key1.toString())
                    servInt.putExtras(b)
                    context.startService(servInt)
                }) {
                Text(stringResource(R.string.boton1))
            }

            ElevatedButton(
                modifier = Modifier.padding(vertical = 34.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(5.dp),
                onClick = {
                    b.putString(MYDEFAULTSTRING_ID, R.string.key2.toString())
                    servInt.putExtras(b)
                    context.startService(servInt)
                }) {
                Text(stringResource(R.string.boton2))
            }
        }
        ElevatedButton(
            modifier = Modifier.padding(vertical = 34.dp).align(Alignment.CenterHorizontally),
            elevation = ButtonDefaults.elevatedButtonElevation(5.dp),
            onClick = {
                context.stopService(servInt)
            }) {
            Text(stringResource(R.string.boton3))

        }
    }
}

companion object {
        const val MYDEFAULTSTRING_ID: String = "pieceOfAudio"
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ManejoServicioComposeTheme {
        Replaying(Modifier)
    }
}
}




