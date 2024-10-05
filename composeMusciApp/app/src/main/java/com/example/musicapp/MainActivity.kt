package com.example.musicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
         MusicApp()
            }
        }
    }


@Composable
fun Modifier.custom_padding_album(): Modifier {

    return this

        .border(2.dp, Color.Black)
        .width(300.dp)
        .height(300.dp)
        .padding(top = 20.dp, start = 20.dp, bottom = 20.dp, end = 20.dp)
}

@Composable
fun Record_info() {
    Row(modifier = Modifier.padding(bottom = 20.dp, top = 20.dp)) {


    Column(
        modifier = Modifier.padding(start = 40.dp, top = 25.dp)
        ,  verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ){
        // image from last.fm
        Image(painter = painterResource(R.drawable.mozart), "Imagen de mozart"
            , modifier = Modifier.custom_padding_album(),
            )

        Text(text = "Bennedictus",  modifier = Modifier.padding( top = 25.dp))
        Text(text = "Requiem",  modifier = Modifier.padding( top = 25.dp))

    }


    }
}

@Composable
fun Playing_info() {

    val currentProgress = 0.25f
    val playedTime = 0.59
    val remainingTime = 2.57

    Row {


        LinearProgressIndicator(
            progress = { currentProgress },
            modifier = Modifier.fillMaxWidth(0.6f)
                .padding(top = 20.dp, start = 20.dp, bottom = 10.dp, end = 20.dp)
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End

        ) {
        Text(text = "Played time = " + playedTime.toString(),   style = TextStyle(
            fontSize =10.sp
        )
        )
        Text(
            text = "Remaining = " + remainingTime.toString(),
            modifier = Modifier.padding(top = 25.dp),
               style = TextStyle(
                fontSize =10.sp
            )
        )
    }


    }

}
//Got Rendering problems using the custom modifier, so i leave it this way

@Composable
fun Modifier.custom_button_modifier(): Modifier {
    val context = LocalContext.current
    val buttonSize = context.resources.getDimension(R.dimen.button_size)

    return this
        .border(2.dp, Color.White)
        .size(buttonSize.dp)
        .padding(top = 5.dp, bottom = 5.dp)
}

fun changeIcon() {
    TODO("Not yet implemented")
}

//Got Rendering problems using the custom modifier, so i leave it this way
@Composable
fun Standard_button(iconImage: Int, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.border(2.dp, Color.White)
        .size(55.dp)
        .padding(top = 5.dp, bottom = 5.dp)
    ) {
        Image(
            painter = painterResource(id = iconImage), // Use your custom drawable
            contentDescription = "Play",
            modifier = Modifier.size(55.dp) // Adjust size as needed
        )
    }
}

@Composable
fun Play_button(onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(55.dp)
            .padding(start = 10.dp, end = 10.dp)
            .border(2.dp, Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.play), // Use your custom drawable
            contentDescription = "Play",
            modifier = Modifier.size(55.dp) // Adjust size as needed
        )
    }
}

@Composable
fun Audio_bar() {

    val volume = 0.7f


    Row {

Column {
    LinearProgressIndicator(
        progress = { volume },
        modifier = Modifier.fillMaxWidth(0.8f)
            .padding(top = 20.dp, start = 20.dp, bottom = 10.dp, end = 20.dp)
    )


    Text(modifier = Modifier.padding(start = 20.dp),text = "Volume", style = TextStyle(fontSize = 10.sp))

}
    }

}

/*icons from https://www.svgrepo.com/
LICENSE: PD License
AUTHOR: Noah Jacobus*/
@Composable
fun Screen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray
    ) {
        Column {
     Record_info()
      Playing_info()

                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 30.dp, bottom = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly )
                {
                    Standard_button(iconImage =R.drawable.previous,onClick={ donothing() })

                    Play_button(onClick={changeIcon()})
                    Standard_button(iconImage =R.drawable.nextcircle,onClick={ donothing() })

                }

Audio_bar()
                Row(modifier = Modifier.fillMaxWidth().padding(top = 30.dp, bottom = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly )
                {
                    Standard_button(iconImage =R.drawable.share,onClick={ donothing() })
                    Standard_button(iconImage =R.drawable.list,onClick={ donothing() })
                    Standard_button(iconImage =R.drawable.list,onClick={ donothing() })
                }


        }
    }
}

fun donothing() {

}


@Preview(showBackground = true)
@Composable
fun MusicApp() {
    Screen()


}